package com.example.multiple.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;
    private String category_name;
    private String category_desc;

    @OneToMany(targetEntity = Product.class, mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> products;

    public Category(){
        products = new HashSet<>();
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public Category(int category_id, String category_name, String category_desc) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_desc = category_desc;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }


}
