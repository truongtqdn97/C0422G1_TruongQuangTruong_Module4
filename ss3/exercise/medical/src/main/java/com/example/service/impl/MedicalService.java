package com.example.service.impl;

import com.example.model.Medical;
import com.example.repository.IMedicalRepository;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<String> showGenderList() {
        return this.iMedicalRepository.showGenderList();
    }

    @Override
    public List<String> showNationList() {
        return this.iMedicalRepository.showNationList();
    }

    @Override
    public List<String> showVehicleList() {
        return this.iMedicalRepository.showVehicleList();
    }

    @Override
    public List<String> showDayList() {
        return this.iMedicalRepository.showDayList();
    }

    @Override
    public List<String> showMonthList() {
        return this.iMedicalRepository.showMonthList();
    }

    @Override
    public List<String> showYearList() {
        return this.iMedicalRepository.showYearList();
    }

    @Override
    public List<String> showYearOfBirth() {
        return this.iMedicalRepository.showYearOfBirth();
    }

    @Override
    public List<Medical> showMedicalList() {
        return this.iMedicalRepository.showMedicalList();
    }

    @Override
    public void save(Medical medical) {
        this.iMedicalRepository.save(medical);
    }

    @Override
    public Medical findById(int medicalId) {
        return this.iMedicalRepository.findById(medicalId);
    }
}
