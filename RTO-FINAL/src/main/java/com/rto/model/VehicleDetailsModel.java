package com.rto.model;

import java.util.Date;


public class VehicleDetailsModel {

	private Long vehicleDetailId;
	private Long vehicleOwnerId;
	private String vehicleType;
	private Integer mfgYear;
	private String vehicleBrand;
	private Date createDate;
	private Date updateDate;
	
	public Long getVehicleDetailId() {
		return vehicleDetailId;
	}
	public void setVehicleDetailId(Long vehicleDetailId) {
		this.vehicleDetailId = vehicleDetailId;
	}
	public Long getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(Long vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(Integer mfgYear) {
		this.mfgYear = mfgYear;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
	

}
