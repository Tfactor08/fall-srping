package com.torvaldsinc.linushostings.cotroller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.torvaldsinc.linushostings.model.*;
import com.torvaldsinc.linushostings.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
            .map(p -> ResponseEntity.ok(p))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        System.out.println("Product: " + savedProduct.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
