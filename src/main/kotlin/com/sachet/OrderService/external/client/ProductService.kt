package com.sachet.OrderService.external.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "PRODUCT-SERVICE/api/v1/product")
interface ProductService {

    @PutMapping("/reduce/{id}")
    fun reduceProduct(
        @PathVariable("id") productId: Long,
        @RequestParam quantity: Long
    ): ResponseEntity<Void>

}