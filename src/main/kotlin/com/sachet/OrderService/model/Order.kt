package com.sachet.OrderService.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "ORDER_DETAILS")
class Order (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var orderId: Long ?= null,

    var productId: Long ?= null,

    var paymentId: Long ?= null,

    var quantity: Long ?= null,

    var orderDate: Instant ?= null,

    var orderStatus: String ?= null,

    var amount: Double ?= null
)