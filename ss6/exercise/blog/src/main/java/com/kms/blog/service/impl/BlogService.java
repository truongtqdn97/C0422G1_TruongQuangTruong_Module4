package com.kms.blog.service.impl;

import com.kms.blog.model.Blog;
import com.kms.blog.repository.IBlogRepository;
import com.kms.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.iBlogRepository.delete(this.findById(id));
    }
}
