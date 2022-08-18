package com.example.service;

import com.example.model.Medical;
import java.util.List;

public interface IMedicalService {
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
