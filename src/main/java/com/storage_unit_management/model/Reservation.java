package com.storage_unit_management.model;


//import jakarta.persistence.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reservationNumber;
    @ManyToOne
    @JoinColumn(name = "storage_unit_id")
    private StorageUnit storageUnit;


    private String startDate;

    private String endDate;

    private String periodType;
    private String customerName;

    // Consider adding a status field (e.g., "Active", "Cancelled", "Completed")
    private String status;

    public Reservation() {
    }

    public Reservation(StorageUnit storageUnit, String startDate, String endDate, String customerName, String status, String reservationNumber
            //, String periodType
        ) {
        this.storageUnit = storageUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
        this.status = status;
        this.reservationNumber = reservationNumber;
        //this.periodType = periodType;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(StorageUnit storageUnit) {
        this.storageUnit = storageUnit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }
}