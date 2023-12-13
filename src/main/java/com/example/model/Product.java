package com.example.model;

import com.example.model.dto.ProductResDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "img", nullable = false)
    private String img;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
    private Color color;

    @Column(name = "newPrice", columnDefinition = "decimal(10,0)", nullable = false)
    private BigDecimal newPrice;

    @Column(name = "prevPrice", columnDefinition = "decimal(10,0)", nullable = false)
    private BigDecimal prevPrice;
    public ProductResDTO toProductResDTO() {
        return new ProductResDTO(id,name,img,prevPrice,newPrice,company,category,color);
    }
}