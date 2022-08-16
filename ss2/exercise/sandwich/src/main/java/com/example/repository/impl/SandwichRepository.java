package com.example.repository.impl;

import com.example.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {
    private static List<String> condiments;
    static{
        condiments = new ArrayList<>();
        condiments.add("Lettuce");
        condiments.add("Tomato");
        condiments.add("Mustard");
        condiments.add("Sprouts");
    }
    @Override
    public List<String> findAllCondiments() {
        return condiments;
    }
}
