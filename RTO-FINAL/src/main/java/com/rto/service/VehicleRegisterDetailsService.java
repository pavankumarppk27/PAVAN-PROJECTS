package com.rto.service;

import com.rto.model.VehicleRegisterDetailsModel;

public interface VehicleRegisterDetailsService {

	public Long saveRegisterDetails(VehicleRegisterDetailsModel vehicleRegisteDetailsModel);	
	public VehicleRegisterDetailsModel vehicleRegisterDetailsFindById(Long id);
	public VehicleRegisterDetailsModel vehicleOwnerId(Long oid);	
	public boolean isExists(Long oid);
	public VehicleRegisterDetailsModel findByRegNum(String regNum);
	public boolean isExistsRegNum(String regNum);

	
	

}
