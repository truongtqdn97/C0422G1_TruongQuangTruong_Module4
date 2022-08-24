package com.kms.blog.service;

import com.kms.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
