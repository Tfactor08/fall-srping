package com.torvaldsinc.linus_hostings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.torvaldsinc.linus_hostings.model.Order;
import com.torvaldsinc.linus_hostings.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class OrderService {
    OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Transactional
    public Order create(Order order) {
        return orderRepo.save(order);
    }
}
