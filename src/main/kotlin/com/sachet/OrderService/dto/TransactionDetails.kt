package com.sachet.OrderService.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

class TransactionDetails (
    var id: Long ?= null,
    var orderId: Long ?= null,
    var paymentMode: String ?= null,
    var referenceNumber: String ?= null,
    var paymentDate: Instant ?= null,
    var paymentStatus: String ?= null,
    var amount: Long ?= null
)