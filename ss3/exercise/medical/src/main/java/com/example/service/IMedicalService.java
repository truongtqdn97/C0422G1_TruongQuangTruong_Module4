package com.example.service;

import java.util.List;

public interface IMedicalService {
    List<String> showGenderList();

    List<String> showNationList();

    List<String> showVehicleList();

    List<String> showDayList();

    List<String> showMonthList();

    List<String> showYearList();

    List<String> showYearOfBirth();
}
