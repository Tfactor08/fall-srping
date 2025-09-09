package com.torvaldsinc.linushostings.cotroller;

import com.torvaldsinc.linushostings.model.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

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
    public String createProducts(@RequestBody Product product) {
        System.out.println("Product: " + product.getName());
        return "Succcess\n";
    }
}
