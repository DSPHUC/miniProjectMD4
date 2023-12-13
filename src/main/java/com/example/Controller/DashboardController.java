package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
@Controller
public class DashboardController {
    @GetMapping("/order-list")
    public String showOrderList() {
        return "products/views/dashboard/orderList";
    }

    @GetMapping("/product-list")
    public String showProductList() {
        return "products/dashboard/productList";
    }
}
