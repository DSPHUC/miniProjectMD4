package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Filter {
    private Long companyId;
    private Long categoryId;
    private Long colorId;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
    private String search;
// fetch lazy phải get mới lấy được
    //

    // kĩ thuật update ảnh: preview img
    // data-grid
}