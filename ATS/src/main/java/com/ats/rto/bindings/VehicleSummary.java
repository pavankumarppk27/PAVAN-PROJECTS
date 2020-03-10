package com.ats.rto.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ats.rto.model.VehicleDetailsModel;
import com.ats.rto.model.VehicleOwnerAddressDetailsModel;
import com.ats.rto.model.VehicleOwnerDetailsModel;
import com.ats.rto.model.VehicleRegisterDetailsModel;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class VehicleSummary {
	
	
	@XmlElement
	VehicleOwnerDetailsModel vehicleOwnerDetailsModel;

	@XmlElement
	VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel;

	@XmlElement
	VehicleDetailsModel vehicleDetailModel;

	@XmlElement
	VehicleRegisterDetailsModel vehicleRegisterDetailsModel;

	

}
