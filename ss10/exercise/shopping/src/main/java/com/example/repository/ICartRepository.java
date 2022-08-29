package com.example.repository;

import com.example.model.Product;

import java.util.Map;

public interface ICartRepository {
    void addProduct(Product product);
    Integer countProductQuantity();
    Integer countItemQuantity();
    Float countTotalPayment();
}
