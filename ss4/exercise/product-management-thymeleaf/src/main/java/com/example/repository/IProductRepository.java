package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showProductList();

    void save(Product product);

    void remove(int pId);

    Product findById(int pId);

    List<Product> findByName(String pName);
}
