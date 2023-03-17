package com.sachet.OrderService.controller

import com.sachet.OrderService.model.Order
import com.sachet.OrderService.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/create")
    fun create(@RequestBody order: Order)
    = ResponseEntity(orderService.save(order), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
    = ResponseEntity(orderService.findById(id), HttpStatus.OK)

    @GetMapping("/all")
    fun getAll() = ResponseEntity(orderService.findAll(), HttpStatus.OK)

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<String> {
        orderService.deleteById(id)
        return ResponseEntity("Successfully Deleted order with id $id", HttpStatus.OK)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody order: Order): ResponseEntity<String> {
        orderService.delete(order)
        return ResponseEntity("Successfully Deleted order with id ${order.orderId}", HttpStatus.OK)
    }

}