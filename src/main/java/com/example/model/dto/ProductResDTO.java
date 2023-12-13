package com.example.model.dto;

import com.example.model.Category;
import com.example.model.Color;
import com.example.model.Company;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Accessors(chain = true)
public class ProductResDTO {
    private Long id;
    private String name;
    private BigDecimal prevPrice;
    private BigDecimal newPrice;
    private String img;
    private CompanyResDTO company;
    private CategoryResDTO category;
    private ColorResDTO color;

    public ProductResDTO(Long id, String name, String img
            , BigDecimal prevPrice, BigDecimal newPrice
            , Company company, Category category, Color color) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.prevPrice = prevPrice;
        this.newPrice = newPrice;
        this.company = company.toCompanyResDTO();
        this.category = category.toCategoryResDTO();
        this.color = color.toColorResDTO();
    }

    public ProductResDTO(Long id, String name, String img
            , String companyName, String categoryName, String colorName,
                         BigDecimal newPrice, BigDecimal prevPrice) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.company = new CompanyResDTO(companyName);
        this.category = new CategoryResDTO(categoryName);
        this.color = new ColorResDTO(colorName);
        this.newPrice = newPrice;
        this.prevPrice = prevPrice;
    }
}