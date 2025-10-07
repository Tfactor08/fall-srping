package com.torvaldsinc.linus_hostings.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.torvaldsinc.linus_hostings.model.Product;

import org.springframework.ui.Model;

@Controller
public class WebController {
    private ProductController productController;

    public WebController(ProductController productController) {
        this.productController = productController;
    }
    
    @GetMapping("/index")
    public String main(Model model) {
        try {
            List<Product> products = productController.getProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "products";
    }
}
