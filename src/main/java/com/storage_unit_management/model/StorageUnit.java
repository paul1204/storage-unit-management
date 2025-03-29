package com.storage_unit_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//import javax.persistence.*;


@Entity
//@Table(name = "STORAGE_UNITS")
//@NoArgsConstructor
//@AllArgsConstructor
public class StorageUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String unitNumber;

    private String description;

    private double sizeInSqFt;

    private boolean isAvailable;

    public StorageUnit(){

    }

    public StorageUnit(String unitNumber, String description, double sizeInSqFt, boolean isAvailable) {
        this.unitNumber = unitNumber;
        this.description = description;
        this.sizeInSqFt = sizeInSqFt;
        this.isAvailable = isAvailable;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSizeInSqFt() {
        return sizeInSqFt;
    }

    public void setSizeInSqFt(double sizeInSqFt) {
        this.sizeInSqFt = sizeInSqFt;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}