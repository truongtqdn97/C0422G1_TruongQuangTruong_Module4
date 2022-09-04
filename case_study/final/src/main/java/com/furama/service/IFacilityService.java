package com.furama.service;

import com.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    void save(Facility facility);
    Page<Facility> findAll(Pageable pageable);
    Facility findById(int id);
    void deleteById(int id);
}
