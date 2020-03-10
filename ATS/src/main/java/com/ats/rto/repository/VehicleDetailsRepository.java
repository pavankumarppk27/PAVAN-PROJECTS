package com.ats.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.rto.entity.VehicleDetailsEntity;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetailsEntity, Serializable> 
{
	public VehicleDetailsEntity findByVehicleOwnerId(Long ownerId);
}
