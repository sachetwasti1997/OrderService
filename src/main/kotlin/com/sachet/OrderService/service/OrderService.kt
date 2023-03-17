package com.sachet.OrderService.service

import com.sachet.OrderService.model.Order

interface OrderService {

    fun save(order: Order): Order
    fun findById(id: Long): Order
    fun findAll(): List<Order>
    fun delete(order: Order)
    fun deleteById(id: Long)

}