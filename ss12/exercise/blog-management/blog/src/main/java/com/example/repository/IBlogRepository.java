package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategory_Id(int category, Pageable pageable);
    Page<Blog> findAllByTopicContaining(String topic, Pageable pageable);
}
