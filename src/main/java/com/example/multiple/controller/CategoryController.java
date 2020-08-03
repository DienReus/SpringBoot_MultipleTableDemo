package com.example.multiple.controller;

import com.example.multiple.model.Category;
import com.example.multiple.model.Product;
import com.example.multiple.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/category")
    public List<Category> getAllCategory(){
          return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("category/{id}")
    public Optional<Category> getById(@PathVariable(value = "id") long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleleCategory(@PathVariable(value = "id") int id, Category category){
        category.setCategory_id(id);
        categoryRepository.delete(category);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@PathVariable(value = "id") int id, @RequestBody Category category){
        category.setCategory_id(id);
        return categoryRepository.saveAndFlush(category);
    }
}
