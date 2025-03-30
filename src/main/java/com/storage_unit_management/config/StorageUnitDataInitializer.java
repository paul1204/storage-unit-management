package com.storage_unit_management.config;

import com.storage_unit_management.model.StorageUnit;
import com.storage_unit_management.repository.StorageUnitRepository;
import jakarta.annotation.PostConstruct; // or javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorageUnitDataInitializer {

//    private final StorageUnitRepository storageUnitRepository;
//
//    @Autowired
//    public StorageUnitDataInitializer(StorageUnitRepository storageUnitRepository) {
//        this.storageUnitRepository = storageUnitRepository;
//    }

//    @PostConstruct
//    public void initializeStorageUnits() {
//        if (storageUnitRepository.count() == 0) { // Check if data already exists
//            List<StorageUnit> initialUnits = List.of(
//                    //new StorageUnit("Small Unit", 50.0, true)
//                    new StorageUnit("102", "Medium Unit", 100.0, true),
//                    new StorageUnit("201", "Large Unit", 200.0, false),
//                    new StorageUnit("202", "Climate Controlled", 150.0, true)
//            );
//
//            storageUnitRepository.saveAll(initialUnits);
//        }
//    }
}