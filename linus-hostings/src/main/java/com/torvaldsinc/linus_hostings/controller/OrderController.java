package com.torvaldsinc.linus_hostings.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.torvaldsinc.linus_hostings.model.*;
import com.torvaldsinc.linus_hostings.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid Order order) {
        Order savedOrder = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
