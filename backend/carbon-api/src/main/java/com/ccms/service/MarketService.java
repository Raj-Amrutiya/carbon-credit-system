package com.ccms.service;

import com.ccms.model.Order;
import com.ccms.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    private final OrderRepo orderRepo;

    public MarketService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public List<Order> findByUserId(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    public Order place(Order order) {
        return orderRepo.save(order);
    }
}
