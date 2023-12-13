package com.example.service.product;

import com.example.model.Product;
import com.example.model.dto.FilterDTO;
import com.example.model.dto.ProductResDTO;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Long id, Product product) {

    }

    @Override
    public Page<ProductResDTO> showAllProduct(FilterDTO filterDTO, Pageable pageable) {

        return productRepository.showAllProduct(filterDTO,pageable);
    }
}
