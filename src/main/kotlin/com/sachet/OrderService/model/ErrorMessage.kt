package com.sachet.OrderService.model

import org.springframework.http.HttpStatus

class ErrorMessage(
    var message: String ?= null,
    var status: HttpStatus ?= null
)