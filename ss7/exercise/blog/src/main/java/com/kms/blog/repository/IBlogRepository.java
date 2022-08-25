package com.kms.blog.repository;

import com.kms.blog.model.Blog;
import com.kms.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllBybTopicContaining(String bTopic, Pageable pageable);

    Page<Blog> findAllBybTopicContainingAndCategory_cNameContaining(String bTopic, String category, Pageable pageable);
}
