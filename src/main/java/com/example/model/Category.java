package com.example.model;

import com.example.model.dto.CategoryResDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public CategoryResDTO toCategoryResDTO(){
        return new CategoryResDTO()
                .setName(name);
    }
}
