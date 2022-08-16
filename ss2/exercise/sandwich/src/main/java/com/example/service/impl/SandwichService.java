package com.example.service.impl;

import com.example.repository.ISandwichRepository;
import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    private ISandwichRepository iSandwichRepository;

    @Override
    public List<String> findAllCondiments() {
        return this.iSandwichRepository.findAllCondiments();
    }
}
