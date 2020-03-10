package com.ats.tag.service;

import java.util.List;

import com.ats.tag.model.PurchaseTagModel;

public interface PurchageTagService {

	public Long countByVehicleRegNum(String vehRegNo);
	public Long saveDtls(Long id,PurchaseTagModel model);
	public Long saveRechargeDtls(Long id,PurchaseTagModel model);
	public PurchaseTagModel findById(Long id);
	public PurchaseTagModel findByVehicleRegNum(String vehRegNo);
	public List<PurchaseTagModel> findByUserId(Long id);
	
	public PurchaseTagModel findByVehicleRegNumAndTagSwitch(String vehRegNo,String tagSwitch);
	/*
	 * public VehicleDetailsModel findByVehicleOwnerId(Long ownerId); public
	 * VehicleRegisterDetailsModel vehicleRegisterNumber(String vehRegNo);
	 */

}
