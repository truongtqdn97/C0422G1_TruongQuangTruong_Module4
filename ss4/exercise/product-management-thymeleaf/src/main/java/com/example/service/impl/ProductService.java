package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> showProductList() {
        return this.iProductRepository.showProductList();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void remove(int pId) {
        this.iProductRepository.remove(pId);
    }

    @Override
    public Product findById(int pId) {
        return this.iProductRepository.findById(pId);
    }

    @Override
    public List<Product> findByName(String pName) {
        return this.iProductRepository.findByName(pName);
    }
}
