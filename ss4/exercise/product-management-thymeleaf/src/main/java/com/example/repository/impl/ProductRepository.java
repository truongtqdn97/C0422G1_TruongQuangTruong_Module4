package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        //(int pId, String pName, int pPrice, String pDescription, String pManufacturer)
        productMap.put(1, new Product(1, "headphone", 1000, "ngon vcl", "Sony"));
        productMap.put(2, new Product(2, "mouse", 2000, "ngon", "MIT"));
        productMap.put(3, new Product(3, "screen", 3333, "nhin co ve ngon", "Samsung"));
        productMap.put(4, new Product(4, "keyboard", 4200, "ngon vcl", "Edra"));
        productMap.put(5, new Product(5, "girlfriend", 99999, "dien nuoc day du", "Parents"));
    }


    @Override
    public List<Product> showProductList() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getpId(), product);
    }

    @Override
    public void remove(int pId) {
        productMap.remove(pId);
    }

    @Override
    public Product findById(int pId) {
        return productMap.get(pId);
    }

    @Override
    public List<Product> findByName(String pName) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getpName().contains(pName)) {
                products.add(product);
            }
        }
        return products;
    }
}
