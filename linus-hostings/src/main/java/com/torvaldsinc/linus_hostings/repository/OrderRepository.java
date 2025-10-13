package com.torvaldsinc.linus_hostings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torvaldsinc.linus_hostings.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}