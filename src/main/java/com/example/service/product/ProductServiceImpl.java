package com.example.service.product;

import com.example.model.Product;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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
        return productRepository
                .findAll();
//                .stream()
//                .map(
//                        product -> new Product(
//                                product.getId().toString()
//                                ,product.getName()
//                                ,product.getCategory().getId().toString()
//                                ,product.getColor().getId().toString()
//                                ,product.getCompany().getId().toString()
//                                ,product.getPrice().toString()
//                                ))
//                .collect(
//                        Collectors
//                                .toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Long id, Product product) {

    }
}
