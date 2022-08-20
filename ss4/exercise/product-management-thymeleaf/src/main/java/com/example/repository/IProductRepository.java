package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showProductList(String pName);

    void save(Product product);

    void remove(int pId);

    Product findById(int pId);
}
