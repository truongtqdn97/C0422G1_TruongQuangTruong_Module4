package com.example.model;

public class Medical {
    private int medicalId;
    private String name;
    private String year;
    private String gender;
    private String nation;
    private String idCard;
    private String vehicle;
    private String vehicleId;
    private String seat;
    private String startDay;
    private String startMonth;
    private String startYear;
    private String endDay;
    private String endMonth;
    private String endYear;
    private String city;

    public Medical() {
    }

    public Medical(int medicalId, String name, String year,
                   String gender, String nation, String idCard,
                   String vehicle, String vehicleId, String seat,
                   String startDay, String startMonth, String startYear,
                   String endDay, String endMonth, String endYear,
                   String city) {
        this.medicalId = medicalId;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleId = vehicleId;
        this.seat = seat;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.city = city;
    }

    public Medical(String name, String year, String gender,
                   String nation, String idCard, String vehicle,
                   String vehicleId, String seat,
                   String startDay, String startMonth, String startYear,
                   String endDay, String endMonth, String endYear,
                   String city) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleId = vehicleId;
        this.seat = seat;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.city = city;
    }

    public int getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(int medicalId) {
        this.medicalId = medicalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
