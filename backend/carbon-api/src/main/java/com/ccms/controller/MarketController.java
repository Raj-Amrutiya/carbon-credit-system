package com.ccms.controller;

import com.ccms.model.Order;
import com.ccms.service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/orders")
    public List<Order> getAll() {
        return marketService.findAll();
    }

    @GetMapping("/orders/user/{userId}")
    public List<Order> getByUser(@PathVariable Long userId) {
        return marketService.findByUserId(userId);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> place(@RequestBody Order order) {
        return new ResponseEntity<>(marketService.place(order), HttpStatus.CREATED);
    }
}
