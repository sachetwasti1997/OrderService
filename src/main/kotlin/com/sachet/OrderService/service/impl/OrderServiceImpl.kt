package com.sachet.OrderService.service.impl

import com.sachet.OrderService.dto.OrderRequest
import com.sachet.OrderService.exception.NotFoundException
import com.sachet.OrderService.external.client.ProductService
import com.sachet.OrderService.model.Order
import com.sachet.OrderService.repository.OrderRepository
import com.sachet.OrderService.service.OrderService
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val productService: ProductService
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
        return orderRepository.save(order)
    }

    override fun findById(id: Long): Order {
        val order = orderRepository.findById(id)
        if (!order.isPresent)throw NotFoundException("Order with Id $id not found")
        return order.get()
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