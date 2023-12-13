package com.example.repository;

import com.example.model.Product;
import com.example.model.dto.FilterDTO;
import com.example.model.dto.ProductResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.example.model.dto.ProductResDTO(p.id, p.name,p.img,p.company.name, p.category.name, p.color.name,p.newPrice,p.prevPrice) " +
            "FROM Product p " +
            "WHERE (:#{#filterDTO.category} = 'allCategory' OR LOWER(p.category.name) = LOWER(:#{#filterDTO.category})) " +
            "AND (:#{#filterDTO.color} = 'allColor' OR LOWER(p.color.name) = LOWER(:#{#filterDTO.color})) " +
            "AND (:#{#filterDTO.company} = 'allCompany' OR LOWER(p.company.name) = LOWER(:#{#filterDTO.company})) " +
            "AND (" +
            "       (:#{#filterDTO.minPrice} = '0' AND :#{#filterDTO.maxPrice} ='0') " +
            "    OR (:#{#filterDTO.minPrice} <= p.newPrice AND :#{#filterDTO.maxPrice} >= p.newPrice)" +
            "    OR (:#{#filterDTO.minPrice} <= p.newPrice " +
            "       AND :#{#filterDTO.maxPrice} <= p.newPrice" +
            "       AND :#{#filterDTO.minPrice}= :#{#filterDTO.maxPrice}" +
            "       )" +
            "    ) " +
            "AND (LOWER(p.name) LIKE CONCAT('%', :#{#filterDTO.search}, '%'))")
    Page<ProductResDTO> showAllProduct(@Param("filterDTO") FilterDTO filterDTO,Pageable pageable);

}
