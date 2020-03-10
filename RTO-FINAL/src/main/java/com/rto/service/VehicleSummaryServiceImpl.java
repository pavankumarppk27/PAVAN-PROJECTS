package com.rto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.bindings.VehicleSummary;
import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.model.VehicleRegisterDetailsModel;

@Service
public class VehicleSummaryServiceImpl implements VehicleSummaryService{

	@Autowired
	VehicleOwnerDetailsService vehicleOwnerDetailsService;

	@Autowired
	VehicleOwnerAddressDetailsService vehicleOwnerAddressDetailsService;

	@Autowired
	VehicleDetailsService vehicleDetailService;

	@Autowired
	VehicleRegisterDetailsService vehicleRegisterDetailsService;
	
	
	@Override
	public VehicleSummary getVehicleDetailsByRegId(String regId) {
		// TODO Auto-generated method stub
		
		VehicleRegisterDetailsModel findByRegNum = vehicleRegisterDetailsService.findByRegNum(regId);
		
		Long ownerId=findByRegNum.getVehicleOwnerId();
		
		VehicleOwnerDetailsModel vehicleOwnerDetailsModel = vehicleOwnerDetailsService.vehicleOwnerDetailsFindById(ownerId);
		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = vehicleOwnerAddressDetailsService.vehicleOwnerId(ownerId);
		VehicleDetailsModel vehicleDetailsModel = vehicleDetailService.vehicleOwnerId(ownerId);
		VehicleRegisterDetailsModel vehicleRegisterDetailsModel = vehicleRegisterDetailsService.vehicleOwnerId(ownerId);
		
		VehicleSummary vehicleSummary=new VehicleSummary();
		
		vehicleSummary.setVehicleOwnerDetailsModel(vehicleOwnerDetailsModel);
		vehicleSummary.setVehicleOwnerAddressDetailsModel(vehicleOwnerAddressDetailsModel);
		vehicleSummary.setVehicleDetailModel(vehicleDetailsModel);
		vehicleSummary.setVehicleRegisterDetailsModel(vehicleRegisterDetailsModel);
		
		return vehicleSummary;
	}

}
