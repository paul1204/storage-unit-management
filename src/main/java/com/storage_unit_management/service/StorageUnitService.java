package com.storage_unit_management.service;

//package com.example.storage.service;


import com.storage_unit_management.exception.ResourceNotFoundException;
import com.storage_unit_management.model.StorageUnit;
import com.storage_unit_management.repository.StorageUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageUnitService {

    private final StorageUnitRepository storageUnitRepository;

    @Autowired
    public StorageUnitService(StorageUnitRepository storageUnitRepository) {
        this.storageUnitRepository = storageUnitRepository;
    }

    public List<StorageUnit> getAllStorageUnits() {
        return storageUnitRepository.findAll();
    }

    public StorageUnit getStorageUnitById(Long id) {
        return storageUnitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage Unit not found with id: " + id));
    }

    public StorageUnit createStorageUnit(StorageUnit storageUnit) {
        return storageUnitRepository.save(storageUnit);
    }

    public StorageUnit updateStorageUnit(Long id, StorageUnit storageUnitDetails) {
        StorageUnit storageUnit = storageUnitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage Unit not found with id: " + id));

       // storageUnit.setUnitNumber(storageUnitDetails.getUnitNumber());
        storageUnit.setDescription(storageUnitDetails.getDescription());
        storageUnit.setSizeInSqFt(storageUnitDetails.getSizeInSqFt());
        storageUnit.setAvailable(storageUnitDetails.isAvailable());

        return storageUnitRepository.save(storageUnit);
    }

    public void deleteStorageUnit(Long id) {
        StorageUnit storageUnit = storageUnitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage Unit not found with id: " + id));

        storageUnitRepository.delete(storageUnit);
    }
}