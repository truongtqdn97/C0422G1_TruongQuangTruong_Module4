package com.example.repository.impl;

import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<String> listLanguages = new ArrayList<>();
    private static List<String> listPageSizes = new ArrayList<>();
    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");

        listPageSizes.add("5");
        listPageSizes.add("10");
        listPageSizes.add("15");
        listPageSizes.add("25");
        listPageSizes.add("50");
        listPageSizes.add("100");
    }

    @Override
    public List<String> showListLanguages() {
        return listLanguages;
    }

    @Override
    public List<String> showListPageSizes() {
        return listPageSizes;
    }
}
