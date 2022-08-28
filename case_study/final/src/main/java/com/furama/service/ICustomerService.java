package com.furama.service;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    void save(Customer customer);
    Page<Customer> findAll(Pageable pageable);
    Customer findById(int id);
    void deleteById(int id);
}
