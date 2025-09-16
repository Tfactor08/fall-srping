package com.torvaldsinc.linushostings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torvaldsinc.linushostings.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
