package com.sachet.OrderService.dto

class OrderRequest (
    var productId: Long ?= null,
    var totalAmount: Double ?= null,
    var quantity: Long ?= null,
    var paymentMode: PaymentMode ?= null
)