package com.ats.rto.model;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleOwnerDetailsModel {

	private Long vehicleOwnerId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private Long phoneNumber;
	private Date createDate;
	private Date updateDate;

	


}
