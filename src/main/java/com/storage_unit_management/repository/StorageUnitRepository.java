package com.storage_unit_management.repository;

//package com.example.storage.repository;


import com.storage_unit_management.model.StorageUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> {

    // You can add custom query methods here if needed, e.g.,
    // List<StorageUnit> findBySizeInSqFtGreaterThan(double size);
    // List<StorageUnit> findByIsAvailable(boolean isAvailable);
}