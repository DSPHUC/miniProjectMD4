package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class HomeController {
        @GetMapping
        public String showHomePage() {
            return "/products/product";
        }
}