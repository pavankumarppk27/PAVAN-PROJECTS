package com.rto.service;

import com.rto.model.VehicleDetailsModel;
/**
 *  service class of vehicle details 
 *  @author vasu
 *
 */
public interface VehicleDetailsService {

	
	public Long saveVehicleDetails(VehicleDetailsModel vehicleDetailsModel);

	public VehicleDetailsModel vehicleDetailsFindById(Long id);
	
	public boolean isPresent(Long oid);
	
	
	public VehicleDetailsModel vehicleOwnerId(Long oid);	
	public boolean isExists(Long oid);
	


}
