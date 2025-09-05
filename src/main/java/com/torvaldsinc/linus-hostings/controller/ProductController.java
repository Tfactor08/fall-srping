package com.torvaldsinc.linushostings.cotroller;

import com.torvaldsinc.linushostings.model.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    ArrayList<Product> products = new ArrayList<>(List.of(
                new Product(1, "shitty shit", 69), new Product(2, "shittier shit", 42)
    ));
    //ArrayList<Product> products;


    @GetMapping
    public ArrayList<Product> getProducts() {
        return products;
    }
}
