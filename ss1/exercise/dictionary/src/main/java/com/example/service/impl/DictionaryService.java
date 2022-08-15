package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> dictionaryStock = new HashMap<>();

    static {
        dictionaryStock.put("heart", "tim");
        dictionaryStock.put("lung", "phổi");
        dictionaryStock.put("liver", "gan");
        dictionaryStock.put("viscera", "phèo");
        dictionaryStock.put("appendix", "ruột thừa");
        dictionaryStock.put("pancreas", "tuỵ");
    }

    @Override
    public String translate(String eng) {
        if (dictionaryStock.get(eng.toLowerCase()) == null) {
            return "Not found!";
        }
        return dictionaryStock.get(eng.toLowerCase());
    }
}
