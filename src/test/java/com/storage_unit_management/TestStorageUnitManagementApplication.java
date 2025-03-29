package com.storage_unit_management;

import org.springframework.boot.SpringApplication;

public class TestStorageUnitManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(StorageUnitManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
