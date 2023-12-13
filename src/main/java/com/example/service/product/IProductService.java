package com.example.service.product;

import com.example.model.Product;
import com.example.model.dto.FilterDTO;
import com.example.model.dto.ProductResDTO;
import com.example.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product,Long> {
    Page<ProductResDTO> showAllProduct(FilterDTO filterDTO, Pageable pageable);
}
