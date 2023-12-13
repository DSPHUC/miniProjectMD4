package com.example.model;

import com.example.model.dto.CompanyResDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
@Accessors(chain = true)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public CompanyResDTO toCompanyResDTO(){
        return new CompanyResDTO()
                .setName(name);
    }
}
