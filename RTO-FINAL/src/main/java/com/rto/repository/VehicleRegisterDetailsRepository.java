package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entities.VehicleOwnerDetailsEntity;
import com.rto.entities.VehicleRegisterDetailsEntity;

@Repository
public interface VehicleRegisterDetailsRepository extends JpaRepository<VehicleRegisterDetailsEntity,Serializable>
{
	public VehicleRegisterDetailsEntity findByVehicleOwnerId(VehicleOwnerDetailsEntity oid);

	public Boolean existsByVehicleOwnerId(VehicleOwnerDetailsEntity oid);
	
	public VehicleRegisterDetailsEntity findByVehicleRegisterNumber(String regNum);
	
	public Boolean existsByVehicleRegisterNumber(String regNum);

}
