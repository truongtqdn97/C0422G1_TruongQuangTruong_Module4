package com.example.model;

public class Product {
    private int pId;
    private String pName;
    private int pPrice;
    private String pDescription;
    private String pManufacturer;

    public Product() {
    }

    public Product(int pId, String pName, int pPrice, String pDescription, String pManufacturer) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
        this.pManufacturer = pManufacturer;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpManufacturer() {
        return pManufacturer;
    }

    public void setpManufacturer(String pManufacturer) {
        this.pManufacturer = pManufacturer;
    }
}
