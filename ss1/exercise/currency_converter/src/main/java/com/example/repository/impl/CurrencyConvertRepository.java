package com.example.repository.impl;

import com.example.repository.ICurrencyRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class CurrencyConvertRepository implements ICurrencyRepository {
    @Override
    public double convert(double usd) {
        return usd * 23000;
    }
}
