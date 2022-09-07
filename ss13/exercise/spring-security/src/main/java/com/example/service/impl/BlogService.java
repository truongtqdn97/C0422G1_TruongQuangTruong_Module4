package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByCategory(int category, Pageable pageable) {
        return this.iBlogRepository.findAllByCategory_Id(category, pageable);
    }

    @Override
    public Page<Blog> findAllByTopic(String topic, Pageable pageable) {
        return this.iBlogRepository.findAllByTopicContaining(topic, pageable);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        this.iBlogRepository.deleteById(id);
    }
}
