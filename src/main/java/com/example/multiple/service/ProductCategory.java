package com.example.multiple.service;


import com.example.multiple.model.Product;

import java.util.List;

public interface ProductCategory {
    List<Product> productList();

    Product findOne(Long id);

    Product addProduct(Product product);

    String deleteProduct(Long id);
}
