package com.ats.tag.service;

import com.ats.rto.model.VehicleDetailsModel;
import com.ats.rto.model.VehicleOwnerAddressDetailsModel;
import com.ats.rto.model.VehicleOwnerDetailsModel;
import com.ats.rto.model.VehicleRegisterDetailsModel;

public interface VehicleDetailsService {
	
	public void saveVehOwnerDtls(VehicleOwnerDetailsModel model);
	public void saveVehOwnerAddrDtls(VehicleOwnerAddressDetailsModel model);
	public void saveVehDtls(VehicleDetailsModel model);
	public void saveVehRegDtls(VehicleRegisterDetailsModel model);
	

}
