package com.storage_unit_management.service;

import com.storage_unit_management.exception.ResourceNotFoundException;
import com.storage_unit_management.model.Reservation;
import com.storage_unit_management.model.StorageUnit;
import com.storage_unit_management.repository.ReservationRepository;
import com.storage_unit_management.repository.StorageUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final StorageUnitRepository storageUnitRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, StorageUnitRepository storageUnitRepository) {
        this.reservationRepository = reservationRepository;
        this.storageUnitRepository = storageUnitRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
    }

    @Transactional
    public Reservation createReservation(StorageUnit storageUnitRequest) {
        StorageUnit storageUnit = storageUnitRepository.findByunitNumber(storageUnitRequest.getUnitNumber());

        if (storageUnit == null) {
            throw new ResourceNotFoundException("Storage Unit not found with unit number: " + storageUnitRequest.getUnitNumber());
        }

        if (!storageUnit.isAvailable()) {
            throw new IllegalStateException("Storage unit is not available.");
        }

        storageUnit.setAvailable(false);
        storageUnitRepository.save(storageUnit);

        Reservation newReservation = new Reservation(storageUnit, "01/01/2025", "12/31/2025", "Customer", "Active", "123");
        return reservationRepository.save(newReservation);
    }

    public Reservation updateReservation(Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = Optional.ofNullable(reservationRepository.findByReservationNumber(reservationDetails.getReservationNumber()));

        Reservation reservation = optionalReservation.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with reservation number: " + reservationDetails.getReservationNumber()));
        //.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));

        reservation.setStartDate(reservationDetails.getStartDate());
        reservation.setEndDate(reservationDetails.getEndDate());
        reservation.setCustomerName(reservationDetails.getCustomerName());
        reservation.setStatus(reservationDetails.getStatus());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = Optional.ofNullable(reservationRepository.findByReservationNumber(reservationDetails.getReservationNumber()));

        Reservation reservation = optionalReservation.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with reservation number: " + reservationDetails.getReservationNumber()));

        reservationRepository.delete(reservation);
    }
}