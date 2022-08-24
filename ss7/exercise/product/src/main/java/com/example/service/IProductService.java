package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> showProductList(String pName, Pageable pageable);

    void save(Product product);

    void remove(int pId);

    void update(Product product);

    Product findById(int pId);
}
