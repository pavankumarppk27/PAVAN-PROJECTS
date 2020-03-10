package com.ats.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.rto.entity.VehicleOwnerDetailsEntity;

@Repository
public interface VehicleOwnerDetailsRepository extends JpaRepository<VehicleOwnerDetailsEntity, Serializable>
{

}
