package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entities.VehicleOwnerDetailsEntity;

@Repository
public interface VehicleOwnerDetailsRepository extends JpaRepository<VehicleOwnerDetailsEntity, Serializable>
{

}
