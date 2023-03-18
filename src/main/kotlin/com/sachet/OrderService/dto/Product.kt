package com.sachet.OrderService.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Product (
    var productId: Long ?= null,
    var productName: String ?= null,
    var price: Double ?= null,
    var quantity: Double ?= null
)