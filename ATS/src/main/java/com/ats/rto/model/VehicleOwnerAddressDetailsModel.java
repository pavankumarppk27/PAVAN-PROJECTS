package com.ats.rto.model;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleOwnerAddressDetailsModel {

	private Long addressId;
	private Long vehicleOwnerId;
	private String houseNo;
	private String streetName;
	private String city;
	private Long zipCode;
	private Date createDate;
	private Date updateDate;
	
	
	
	
}
