package com.example.phonemanagement.service;

import com.example.phonemanagement.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
