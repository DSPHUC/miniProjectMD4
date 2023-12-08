package com.example.Controller;

import com.example.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class HomeController {
    private final ProductServiceImpl productService;

    @GetMapping
    public String showHomePage() {
        return "/products/views/product";
    }

}