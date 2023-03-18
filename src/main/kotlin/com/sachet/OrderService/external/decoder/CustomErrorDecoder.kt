package com.sachet.OrderService.external.decoder

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.sachet.OrderService.exception.CustomException
import com.sachet.OrderService.external.response.ErrorMessage
import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class CustomErrorDecoder: ErrorDecoder {
    override fun decode(p: String?, response: Response?): Exception {
        val objectMapper = ObjectMapper()
        val errorMessage = objectMapper.readValue(
            response?.body()?.asInputStream(),
            ErrorMessage::class.java
        )
        return CustomException(
            errorMessage.message,
            errorMessage.status?.toString(),
            response?.status()
        )
    }

}