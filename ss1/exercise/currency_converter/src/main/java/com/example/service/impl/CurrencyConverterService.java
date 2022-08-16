package com.example.service.impl;

import com.example.repository.ICurrencyRepository;
import com.example.service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService implements ICurrencyConverterService {
    @Autowired
    private ICurrencyRepository iCurrencyRepository;

    @Override
    public double convert(double usd) {
        return this.iCurrencyRepository.convert(usd);
    }
}
