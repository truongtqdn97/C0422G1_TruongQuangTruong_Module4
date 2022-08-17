package com.example.repository;

import com.example.model.Medical;

import java.util.List;

public interface IMedicalRepository {
    List<String> showGenderList();

    List<String> showNationList();

    List<String> showVehicleList();

    List<String> showDayList();

    List<String> showMonthList();

    List<String> showYearList();

    List<String> showYearOfBirth();

    List<Medical> showMedicalList();

    void save(Medical medical);

    Medical findById(int medicalId);
}
