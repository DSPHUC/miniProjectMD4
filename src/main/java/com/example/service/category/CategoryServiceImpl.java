package com.example.service.category;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository
                .findAll()
               /* .stream()
                .map(
                        category -> new CategoryResponse(
                                category.getId().toString()
                                ,category.getName()))
                .collect(
                        Collectors
                                .toList())*/;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Long id, Category category) {

    }
}
