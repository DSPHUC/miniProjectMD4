package com.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FilterDTO {
    private String search = "";
    private String category = "allCategory";
    private String company = "allCompany";
    private String color = "allColor";
    private String maxPrice = "0";
    private String minPrice = "0";
}