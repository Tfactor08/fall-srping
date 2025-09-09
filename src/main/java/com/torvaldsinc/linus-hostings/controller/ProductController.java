package com.torvaldsinc.linushostings.cotroller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.torvaldsinc.linushostings.model.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    ArrayList<Product> products = new ArrayList<>(List.of(
                new Product(1, "Shitty shit", 69), new Product(2, "Shittier shit", 42)
    ));

    @GetMapping
    public ArrayList<Product> getProducts() {
        return products;
    }

    @PostMapping
    public ResponseEntity<Product> createProducts(@RequestBody Product product) {
        products.add(product);
        System.out.println("Product: " + product.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
