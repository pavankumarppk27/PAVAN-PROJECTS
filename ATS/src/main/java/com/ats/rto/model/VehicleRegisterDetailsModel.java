package com.ats.rto.model;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleRegisterDetailsModel {

	private Long vehicleRegisterId;
	private Long vehicleOwnerId;
	//@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date registerDate;
	private String registerCenter;
	private Date createDate;
	private Date updateDate;
	private String vehicleRegisterNumber;
		
	

}
