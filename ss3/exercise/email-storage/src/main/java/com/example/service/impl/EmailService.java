package com.example.service.impl;

import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> showListLanguages() {
        return this.iEmailRepository.showListLanguages();
    }

    @Override
    public List<String> showListPageSizes() {
        return this.iEmailRepository.showListPageSizes();
    }
}
