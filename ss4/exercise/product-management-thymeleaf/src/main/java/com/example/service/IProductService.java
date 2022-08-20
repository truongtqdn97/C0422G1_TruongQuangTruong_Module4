package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showProductList(String pName);

    void save(Product product);

    void remove(int pId);

    Product findById(int pId);
}
