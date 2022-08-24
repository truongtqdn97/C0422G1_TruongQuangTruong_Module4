package com.kms.blog.service;

import com.kms.blog.model.Blog;
import com.kms.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    void save(Blog blog);

    Blog findById(Integer id);

    void remove(int id);

    Page<Blog> findByTopic(String bTopic, Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);
}
