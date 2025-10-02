package com.torvaldsinc.linus_hostings.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.torvaldsinc.linus_hostings.model.*;
import com.torvaldsinc.linus_hostings.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAll();
    }

    //@GetMapping("/{id}")
    //public ResponseEntity<Product> getProduct(@PathVariable Long id) {
    //    return productService.getById(id)
    //        .map(p -> ResponseEntity.ok(p))
    //        .orElse(ResponseEntity.notFound().build());
    //}

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Product savedProduct = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody @Valid Product product) {
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> getProducts(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer min,
        @RequestParam(required = false) Integer max,
        @PageableDefault(page = 0, size = 10, sort = "name") Pageable pageable
    ) {
        return ResponseEntity.ok(productService.getByFilter(name, min, max, pageable));
    }
    
}
