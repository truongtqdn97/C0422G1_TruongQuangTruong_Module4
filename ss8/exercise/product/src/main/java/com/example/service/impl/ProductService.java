package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> showProductList(String pName, Pageable pageable) {
        return this.iProductRepository.findAllByNameContaining(pName, pageable);
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void remove(int pId) {
        this.iProductRepository.delete(this.findById(pId));
    }

    @Override
    public void update(Product product) {
        this.save(product);
    }

    @Override
    public Product findById(int pId) {
        return this.iProductRepository.findById(pId).orElse(null);
    }
}
