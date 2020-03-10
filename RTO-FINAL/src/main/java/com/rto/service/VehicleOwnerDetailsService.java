package com.rto.service;

import com.rto.model.VehicleOwnerDetailsModel;

public interface VehicleOwnerDetailsService {

	public Long saveOwnerDetails(VehicleOwnerDetailsModel vehicleOwnerDetailsModel);
	public VehicleOwnerDetailsModel vehicleOwnerDetailsFindById(Long id);

	
	
}
