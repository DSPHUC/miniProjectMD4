package com.example.repository;

import com.example.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findPriceByMaxPrice(BigDecimal maxPrice);

    Price findPriceByMinPrice(BigDecimal minPrice);

    Price findPriceByMinPriceAndMaxPrice(BigDecimal minPrice, BigDecimal maxPrice);

}
