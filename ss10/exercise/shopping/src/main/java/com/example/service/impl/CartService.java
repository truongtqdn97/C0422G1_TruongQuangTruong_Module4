package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ICartRepository;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;


public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void addProduct(Product product) {
        this.iCartRepository.addProduct(product);
    }

    @Override
    public Integer countProductQuantity() {
        return this.iCartRepository.countProductQuantity();
    }

    @Override
    public Integer countItemQuantity() {
        return this.iCartRepository.countItemQuantity();
    }

    @Override
    public Float countTotalPayment() {
        return this.iCartRepository.countTotalPayment();
    }
}
