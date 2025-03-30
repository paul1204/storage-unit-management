package com.storage_unit_management.repository;

import com.storage_unit_management.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    @Query("SELECT r FROM Reservation r WHERE r.reservationNumber = :reservationNumber")
    Reservation findByReservationNumber(@Param("reservationNumber") String reservationNumber);
}