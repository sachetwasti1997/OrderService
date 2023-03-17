package com.sachet.OrderService.exceptionHandler

import com.sachet.OrderService.exception.NotFoundException
import com.sachet.OrderService.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFoundException(ex: NotFoundException): ErrorMessage {
        return ErrorMessage(message = ex.message, status = HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun genericException(exception: Exception): ErrorMessage {
        return ErrorMessage(message = exception.message, status = HttpStatus.INTERNAL_SERVER_ERROR)
    }

}