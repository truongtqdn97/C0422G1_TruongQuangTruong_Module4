package com.example.service;

import com.example.model.Product;

public interface ICartService {
    void addProduct(Product product);
    Integer countProductQuantity();
    Integer countItemQuantity();
    Float countTotalPayment();
}
