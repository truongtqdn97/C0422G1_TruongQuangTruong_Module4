package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    void save(Book book);

    Book findById(int id);

    Page<Book> findAll(Pageable pageable);
}
