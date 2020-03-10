package com.ats.tag.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PurchaseTagModel {

	private Long tagId;
	private String tagRegId;
	private String vehicleRegNum;
	private String vehicleType;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date tagStartDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date tagExpiryDate;
	private Double tagBal;
	private Long userId;
	private String tagSwitch;
	private Date createdDate;
	private Date updatedDate;

	/*
	 * 
	 * TAG_SEQ (PK) TAG_ID VEHICLE_REG_NUM VEHICLE_TYPE TAG_START_DT TAG_EXPIRY_DT
	 * TAG_BAL USER_ID
	 * 
	 * 
	 */
}
