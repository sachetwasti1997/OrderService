package com.sachet.OrderService.dto

import com.sachet.OrderService.model.Order

class OrderGetRes (
    var order: Order ?= null,
    var product: Product ?= null,
    var transactionDetails: TransactionDetails ?= null
)