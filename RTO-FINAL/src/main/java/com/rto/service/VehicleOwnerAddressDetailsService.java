package com.rto.service;

import com.rto.model.VehicleOwnerAddressDetailsModel;

public interface VehicleOwnerAddressDetailsService {

	public Long saveOwnerAddressDetails(VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel); 

	//public void processVehicleOwnerAddressDetailsLogInForm(VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel); 
	public VehicleOwnerAddressDetailsModel VehicleOwnerAddressDetailsFindById(Long id);

			
	public boolean isPresent(Long oid);
	
	public VehicleOwnerAddressDetailsModel vehicleOwnerId(Long oid);	
	public boolean isExists(Long oid);
	
	
}
