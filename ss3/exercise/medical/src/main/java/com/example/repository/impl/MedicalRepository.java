package com.example.repository.impl;

import com.example.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationList = new ArrayList<>();
    private static List<String> vehicleList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();
    private static List<String> yearOfBirthList = new ArrayList<>();

    static {
        genderList.add("Nam");
        genderList.add("Nũ");
        genderList.add("7 màu");

        nationList.add("Việt Nam");
        nationList.add("Thailand");
        nationList.add("Hong-kong");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác");

        for (int i = 1; i < 32; i++) {
            dayList.add(String.valueOf(i));
        }

        for (int i = 1; i < 13; i++) {
            monthList.add(String.valueOf(i));
        }

        for (int i = 2019; i < 2023; i++) {
            yearList.add(String.valueOf(i));
        }

        for (int i = 1950; i < 2023; i++) {
            yearOfBirthList.add(String.valueOf(i));
        }
    }

    @Override
    public List<String> showGenderList() {
        return genderList;
    }

    @Override
    public List<String> showNationList() {
        return nationList;
    }

    @Override
    public List<String> showVehicleList() {
        return vehicleList;
    }

    @Override
    public List<String> showDayList() {
        return dayList;
    }

    @Override
    public List<String> showMonthList() {
        return monthList;
    }

    @Override
    public List<String> showYearList() {
        return yearList;
    }

    @Override
    public List<String> showYearOfBirth() {
        return yearOfBirthList;
    }
}
