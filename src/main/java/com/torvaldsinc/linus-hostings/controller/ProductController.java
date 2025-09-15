package com.torvaldsinc.linushostings.cotroller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.torvaldsinc.linushostings.model.*;
import com.torvaldsinc.linushostings.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repo;

    @GetMapping
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProducts(@RequestBody Product product) {
        Product savedProduct = repo.save(product);
        System.out.println("Product: " + savedProduct.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
