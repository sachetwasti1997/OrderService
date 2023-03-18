package com.sachet.OrderService.external.response

import org.springframework.http.HttpStatus

class ErrorMessage (
    val message: String ?= null,
    val status: HttpStatus ?= null
)