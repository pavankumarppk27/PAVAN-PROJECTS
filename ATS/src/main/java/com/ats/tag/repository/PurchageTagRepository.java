package com.ats.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.tag.entity.PurchaseTagEntity;
import com.ats.user.entity.UserEntity;

@Repository
public interface PurchageTagRepository extends JpaRepository<PurchaseTagEntity, Long> {

	//@Query("select count(*) from PurchaseTagEntity where vehRegNo=:vehRegNo")
	public Long countByVehicleRegNum(String vehRegNo);

	public PurchaseTagEntity findByVehicleRegNum(String vehRegNo);

	public List<PurchaseTagEntity> findByUserId(UserEntity entity);

	public PurchaseTagEntity findByTagRegId(String tagRegId);
	
	public List<String> findByVehicleType(String vehicleType);

	public boolean existsByTagRegId(String tagRegId);

	//@Query("select tagBal from PurchaseTagEntity where tagSwitch=:tagSwitch")
	public PurchaseTagEntity findByTagSwitch(String tagSwitch);
	
	public boolean existsByTagSwitch(String tagSwitch);
	
	public PurchaseTagEntity findByVehicleRegNumAndTagSwitch(String vehRegNo,String tagSwitch);

	public boolean existsByVehicleRegNumAndTagSwitch(String vehRegNo,String tagSwitch);

}
