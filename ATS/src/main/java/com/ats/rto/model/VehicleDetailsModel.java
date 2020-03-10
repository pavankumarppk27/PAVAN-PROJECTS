package com.ats.rto.model;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleDetailsModel {

	private Long vehicleDetailId;
	private Long vehicleOwnerId;
	private String vehicleType;
	private Integer mfgYear;
	private String vehicleBrand;
	private Date createDate;
	private Date updateDate;
	
	
	
	

}
