package com.torvaldsinc.linus_hostings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torvaldsinc.linus_hostings.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>/*, JpaSpecificationExecutor<Product>*/ {
    public List<Product> findByNameIgnoreCase(String name);
}
