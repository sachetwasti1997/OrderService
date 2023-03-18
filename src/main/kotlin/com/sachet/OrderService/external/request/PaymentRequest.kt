package com.sachet.OrderService.external.request

import com.sachet.OrderService.dto.PaymentMode

class PaymentRequest(
    var orderId: Long ?= null,
    var amount: Double ?= null,
    var referenceNumber: String ?= null,
    var paymentMode: PaymentMode ?= null
)