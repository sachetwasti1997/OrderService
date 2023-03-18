package com.sachet.OrderService.config

import com.sachet.OrderService.external.decoder.CustomErrorDecoder
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
    @Bean
    fun errorDecoder(): ErrorDecoder {
        return CustomErrorDecoder()
    }
}