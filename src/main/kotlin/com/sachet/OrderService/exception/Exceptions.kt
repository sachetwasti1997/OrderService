package com.sachet.OrderService.exception

class NotFoundException(
    private val errorMessage: String
): RuntimeException(errorMessage)

class CustomException(
    private val errorMessage: String ?= null,
    private val errorCode: String ?= null,
    private val status: Int ?= null
): RuntimeException(errorMessage)