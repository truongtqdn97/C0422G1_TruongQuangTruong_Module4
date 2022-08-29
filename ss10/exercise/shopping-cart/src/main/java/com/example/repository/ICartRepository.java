package com.example.repository;

import com.example.model.Cart;
import com.example.model.Product;

public interface ICartRepository {
    void addProduct(Product product, Cart cart);
    void subProduct(Product product, Cart cart);
    Integer countProductQuantity(Cart cart);
    Integer countItemQuantity(Cart cart);
    Float countTotalPayment(Cart cart);
}
