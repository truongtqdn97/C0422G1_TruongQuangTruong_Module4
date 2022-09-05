package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id) {
        Blog blog = this.iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<Blog>> viewBlogList(@RequestParam String topic,
                                                    @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findAllByTopic(topic, pageable);

        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping(value = "/list/category/{category}")
    public ResponseEntity<Page<Blog>> viewBlogListByCategory(@PathVariable int category,
                                                             @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findByCategory(category, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
