package com.ats.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.rto.entity.VehicleRegisterDetailsEntity;

@Repository
public interface VehicleRegisterDetailsRepository extends JpaRepository<VehicleRegisterDetailsEntity,Serializable>
{
	public VehicleRegisterDetailsEntity vehicleRegisterNumber(String vehRegNo);
}
