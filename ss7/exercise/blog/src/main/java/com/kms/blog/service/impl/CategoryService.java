package com.kms.blog.service.impl;

import com.kms.blog.model.Category;
import com.kms.blog.repository.ICategoryRepository;
import com.kms.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }
}
