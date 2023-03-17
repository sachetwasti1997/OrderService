package com.sachet.OrderService.exception

class NotFoundException(
    private val errorMessage: String
): RuntimeException(errorMessage)