package com.kms.blog.service.impl;

import com.kms.blog.model.Blog;
import com.kms.blog.repository.IBlogRepository;
import com.kms.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

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

    @Override
    public Page<Blog> findByTopic(String bTopic, Pageable pageable) {
        return this.iBlogRepository.findAllBybTopicContaining(bTopic, pageable);
    }

    @Override
    public Page<Blog> findByCategory(String category, String bTopic, Pageable pageable) {
        return this.iBlogRepository.findAllBybTopicContainingAndCategory_cNameContaining(category, bTopic, pageable);
    }

}
