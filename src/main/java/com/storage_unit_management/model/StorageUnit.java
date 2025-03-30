package com.storage_unit_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "STORAGE_UNITS")
public class StorageUnit {

    @Id
    @Column(name =  "storage_unit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String unitNumber;

    private String description;

    private double sizeInSqFt;

    private boolean isAvailable;

    private String unitSize;

    public StorageUnit() {
    }

    public StorageUnit(String unitNumber, String description, double sizeInSqFt, boolean isAvailable, String unitSize) {
        this.unitNumber = unitNumber;
        this.description = description;
        this.sizeInSqFt = sizeInSqFt;
        this.isAvailable = isAvailable;
        this.unitSize = unitSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSize() {return unitSize;}

    public void setSize(String unitSize) {this.unitSize = unitSize;}
}