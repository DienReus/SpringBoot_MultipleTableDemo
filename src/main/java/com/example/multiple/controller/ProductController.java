package com.example.multiple.controller;

import com.example.multiple.model.Product;
import com.example.multiple.repository.CategoryRepository;
import com.example.multiple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/product")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("product/{id}")
    public Optional<Product> getById(@PathVariable(value = "id") long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        product.setCategory(categoryRepository.findById(product.getCategory_id()).get());
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleleProduct(@PathVariable(value = "id") long id, Product product){
        product.setProduct_id(id);
        productRepository.delete(product);
    }

    @PutMapping("/product/{id}")
    public Product update(@PathVariable(value = "id") long id, @RequestBody Product product){
        product.setProduct_id(id);
        product.setCategory(categoryRepository.findById(product.getCategory_id()).get());
        return productRepository.saveAndFlush(product);
    }
}
