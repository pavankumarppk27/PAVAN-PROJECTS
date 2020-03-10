package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entities.VehicleDetailsEntity;
import com.rto.entities.VehicleOwnerDetailsEntity;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetailsEntity, Serializable> 
{
	public VehicleDetailsEntity findByVehicleOwnerId(VehicleOwnerDetailsEntity oid);

	public Boolean existsByVehicleOwnerId(VehicleOwnerDetailsEntity oid);

}
