package com.storage_unit_management.controller;

//package com.example.storage.controller;


import com.storage_unit_management.model.StorageUnit;
import com.storage_unit_management.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage-units")
public class StorageUnitController {

    private final StorageUnitService storageUnitService;

    @Autowired
    public StorageUnitController(StorageUnitService storageUnitService) {
        this.storageUnitService = storageUnitService;
    }

    @GetMapping
    public ResponseEntity<List<StorageUnit>> getAllStorageUnits() {
        return ResponseEntity.ok(storageUnitService.getAllStorageUnits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageUnit> getStorageUnitById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(storageUnitService.getStorageUnitById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<StorageUnit> createStorageUnit(@RequestBody StorageUnit storageUnit) {
        return new ResponseEntity<>(storageUnitService.createStorageUnit(storageUnit), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StorageUnit> updateStorageUnit(@PathVariable Long id, @RequestBody StorageUnit storageUnitDetails) {
        try {
            return ResponseEntity.ok(storageUnitService.updateStorageUnit(id, storageUnitDetails));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorageUnit(@PathVariable Long id) {
        try {
            storageUnitService.deleteStorageUnit(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}