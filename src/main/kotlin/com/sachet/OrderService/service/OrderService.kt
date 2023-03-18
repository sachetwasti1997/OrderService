package com.sachet.OrderService.service

import com.sachet.OrderService.dto.OrderGetRes
import com.sachet.OrderService.dto.OrderRequest
import com.sachet.OrderService.model.Order

interface OrderService {

    fun save(orderRequest: OrderRequest): Order
    fun findById(id: Long): OrderGetRes
    fun findAll(): List<Order>
    fun delete(order: Order)
    fun deleteById(id: Long)

}