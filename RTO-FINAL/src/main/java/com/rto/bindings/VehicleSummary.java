package com.rto.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.model.VehicleRegisterDetailsModel;

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
