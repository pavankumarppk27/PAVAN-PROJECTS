package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entities.VehicleOwnerAddressDetailsEntity;
import com.rto.entities.VehicleOwnerDetailsEntity;

@Repository
public interface VehicleOwnerAddressDetailsRepository
		extends JpaRepository<VehicleOwnerAddressDetailsEntity, Serializable> {

	public VehicleOwnerAddressDetailsEntity findByVehicleOwnerId(VehicleOwnerDetailsEntity oid);

	public Boolean existsByVehicleOwnerId(VehicleOwnerDetailsEntity oid);
	
	

}
