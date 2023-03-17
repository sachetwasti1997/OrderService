package com.sachet.OrderService.repository

import com.sachet.OrderService.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long>