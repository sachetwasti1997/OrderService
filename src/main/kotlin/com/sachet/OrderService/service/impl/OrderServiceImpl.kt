package com.sachet.OrderService.service.impl

import com.sachet.OrderService.dto.OrderGetRes
import com.sachet.OrderService.dto.OrderRequest
import com.sachet.OrderService.dto.Product
import com.sachet.OrderService.dto.TransactionDetails
import com.sachet.OrderService.exception.NotFoundException
import com.sachet.OrderService.external.client.PaymentService
import com.sachet.OrderService.external.client.ProductService
import com.sachet.OrderService.external.request.PaymentRequest
import com.sachet.OrderService.model.Order
import com.sachet.OrderService.repository.OrderRepository
import com.sachet.OrderService.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.time.Instant

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val productService: ProductService,
    private val paymentService: PaymentService,
    private val restTemplate: RestTemplate
) : OrderService {
    override fun save(orderRequest: OrderRequest): Order {
        productService.reduceProduct(orderRequest.productId!!, orderRequest.quantity!!)
        val order = Order().apply {
            amount = orderRequest.totalAmount
            orderStatus = "CREATED"
            productId = orderRequest.productId
            orderDate = Instant.now()
            quantity = orderRequest.quantity
        }
        val orderRes = orderRepository.save(order)
        val paymentRequest = PaymentRequest().apply {
            orderId = orderRes.orderId
            paymentMode = orderRequest.paymentMode
            amount = orderRequest.totalAmount
        }
        var orderStatus: String ?= null
        val transaction: ResponseEntity<Long?>
        orderStatus = try {
            transaction = paymentService.doPayment(paymentRequest)
            order.paymentId = transaction.body
            "PLACED"
        }catch (ex: Exception) {
            "PAYMENT_FAILED"
        }

        order.orderStatus = orderStatus
        return orderRepository.save(order)
    }

    override fun findById(id: Long): OrderGetRes {
        val order = orderRepository.findById(id)
        if (!order.isPresent)throw NotFoundException("Order with Id $id not found")
        val orderRes = order.get()
        val product = restTemplate.getForObject(
            "http://PRODUCT-SERVICE/api/v1/product/"+orderRes.productId,
            Product::class.java
        )
        val transaction = restTemplate.getForObject(
            "http://PAYMENT-SERVICE/api/v1/payment/"+orderRes.paymentId,
            TransactionDetails::class.java
        )
        return OrderGetRes(orderRes, product, transaction)
    }

    override fun findAll(): List<Order> {
        return orderRepository.findAll()
    }

    override fun delete(order: Order) {
        orderRepository.delete(order)
    }

    override fun deleteById(id: Long) {
        orderRepository.deleteById(id)
    }
}