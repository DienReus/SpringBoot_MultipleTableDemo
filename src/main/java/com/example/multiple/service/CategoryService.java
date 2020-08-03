package com.example.multiple.service;

import com.example.multiple.model.Category;
import com.example.multiple.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> categoryList();

    Optional<Category> findOne(Long id);

    Category addCategory(Category category);

    void deleteCategory(Long id);
    Category updateCategory(Category category);

}
