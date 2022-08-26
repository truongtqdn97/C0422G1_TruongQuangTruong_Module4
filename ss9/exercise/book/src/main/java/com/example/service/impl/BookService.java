package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public void save(Book book) {
        this.iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.iBookRepository.findAll(pageable);
    }
}
