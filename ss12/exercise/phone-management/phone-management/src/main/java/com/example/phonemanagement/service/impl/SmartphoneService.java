package com.example.phonemanagement.service.impl;

import com.example.phonemanagement.model.Smartphone;
import com.example.phonemanagement.repository.ISmartphoneRepository;
import com.example.phonemanagement.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }

    @Override
    public Smartphone findById(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}