package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByCategory(int category, Pageable pageable);
    Blog findById(int id);
}
