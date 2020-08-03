package com.example.multiple.service;

import com.example.multiple.model.Category;
import com.example.multiple.model.Product;
import com.example.multiple.repository.CategoryRepository;
import com.example.multiple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Autowired
    public CategoryImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findOne(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
         categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Category category) {
       return categoryRepository.saveAndFlush(category);
    }



}
