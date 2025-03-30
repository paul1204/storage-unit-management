package com.storage_unit_management.controller;

//package com.example.storage.controller;

import com.storage_unit_management.model.Reservation;
import com.storage_unit_management.model.StorageUnit;
import com.storage_unit_management.service.ReservationService;
import com.storage_unit_management.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;
    private final StorageUnitService storageUnitService;

    @Autowired
    public ReservationController(ReservationService reservationService, StorageUnitService storageUnitService) {
        this.reservationService = reservationService;
        this.storageUnitService = storageUnitService;
    }

    @GetMapping("/all-reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/storage-units")
    public ResponseEntity<List<StorageUnit>> getReservationById() {
        try {
            return ResponseEntity.ok( storageUnitService.getAllStorageUnits());
        } catch (Exception e) {

            System.out.println(e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reservations/reserveUnit") // Create reservation for a specific storage unit
    public ResponseEntity<Reservation> createReservation(@RequestBody StorageUnit storageUnit) {
        try {
            Reservation createdReservation = reservationService.createReservation(storageUnit);
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e + " !!!!!!!!!!!!!!!!");
            return ResponseEntity.badRequest().build(); // Or handle specific exceptions with different status codes
        }
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservationDetails) {
        try {
            Reservation updatedReservation = reservationService.updateReservation(reservationDetails);
            return ResponseEntity.ok(updatedReservation);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReservation(@RequestBody Reservation reservationDetails) {
        try {
            reservationService.deleteReservation(reservationDetails);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}