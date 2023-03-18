package com.sachet.OrderService.external.client

import com.sachet.OrderService.dto.TransactionDetails
import com.sachet.OrderService.external.request.PaymentRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "PAYMENT-SERVICE/api/v1/payment")
interface PaymentService {
    @PostMapping
    fun doPayment(@RequestBody paymentRequest: PaymentRequest)
    : ResponseEntity<Long?>
}