package com.example.Controller.restController;

import com.example.model.Price;
import com.example.service.price.PriceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@AllArgsConstructor
public class PriceRestController {
    private final PriceServiceImpl priceService;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Price> prices = priceService.findAll();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
