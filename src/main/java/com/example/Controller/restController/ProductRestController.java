package com.example.Controller.restController;

import com.example.model.dto.FilterDTO;
import com.example.model.dto.ProductResDTO;
import com.example.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<Page<ProductResDTO>> getAllProduct(@PageableDefault(size = 2) Pageable pageable, FilterDTO filter) {
        Page<ProductResDTO> result = productService.showAllProduct(filter, pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
