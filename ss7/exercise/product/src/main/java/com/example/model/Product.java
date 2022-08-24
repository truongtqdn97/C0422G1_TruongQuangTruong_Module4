package com.example.model;


import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    private String name;
    private int pPrice;
    private String pDescription;
    private String pManufacturer;

    public Product() {
    }

    public Product(int pId, String name, int pPrice, String pDescription, String pManufacturer) {
        this.pId = pId;
        this.name = name;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
        this.pManufacturer = pManufacturer;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
