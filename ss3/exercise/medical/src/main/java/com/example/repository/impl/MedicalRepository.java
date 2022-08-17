package com.example.repository.impl;

import com.example.model.Medical;
import com.example.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static Map<Integer, Medical> medicalMap = new HashMap<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationList = new ArrayList<>();
    private static List<String> vehicleList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();
    private static List<String> yearOfBirthList = new ArrayList<>();

    //String name, String year, String gender,
//                   String nation, String idCard, String vehicle,
//                   String vehicleId, String seat,
//                   String startDay, String startMonth, String startYear,
//                   String endDay, String endMonth, String endYear,
//                   String city
    static {
        medicalMap.put(1, new Medical(1, "Cena", "1999", "Nam",
                "Thailand", "123234345", "Ô tô",
                "VN324", "A32",
                "12", "12", "2019",
                "12", "12", "2019", "DN"));
        medicalMap.put(2, new Medical(2, "Rock", "1996", "Nam",
                "Hong-kong", "987876652", "Tàu bay",
                "VN224", "A12",
                "03", "12", "2019",
                "03", "12", "2019", "HN"));
        medicalMap.put(3, new Medical(3, "Lesna", "1998", "Nũ",
                "Thailand", "567456234", "Khác",
                "EN328", "C04",
                "08", "07", "2019",
                "08", "07", "2019", "HCM"));

        genderList.add("Nam");
        genderList.add("Nữ");
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

    @Override
    public List<Medical> showMedicalList() {
        return new ArrayList<>(medicalMap.values());
    }

    @Override
    public void save(Medical medical) {
        medicalMap.put(medical.getMedicalId(), medical);
    }

    @Override
    public Medical findById(int medicalId) {
        return medicalMap.get(medicalId);
    }
}
