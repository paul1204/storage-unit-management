package com.storage_unit_management.repository;

import com.storage_unit_management.model.StorageUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> {

    @Query("SELECT s FROM StorageUnit s WHERE s.unitNumber = :unitNumber")
    StorageUnit findByunitNumber(@Param("unitNumber") String unitNumber);
}