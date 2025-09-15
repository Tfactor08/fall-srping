package com.torvaldsinc.linushostings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torvaldsinc.linushostings.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
