package com.rto.model;

import java.util.Date;

public class VehicleRegisterDetailsModel {

	private Long vehicleRegisterId;
	private Long vehicleOwnerId;
	//@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date registerDate;
	private String registerCenter;
	private Date createDate;
	private Date updateDate;
	private String vehicleRegisterNumber;
	public Long getVehicleRegisterId() {
		return vehicleRegisterId;
	}
	public void setVehicleRegisterId(Long vehicleRegisterId) {
		this.vehicleRegisterId = vehicleRegisterId;
	}
	public Long getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(Long vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterCenter() {
		return registerCenter;
	}
	public void setRegisterCenter(String registerCenter) {
		this.registerCenter = registerCenter;
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
	public String getVehicleRegisterNumber() {
		return vehicleRegisterNumber;
	}
	public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
		this.vehicleRegisterNumber = vehicleRegisterNumber;
	}
	@Override
	public String toString() {
		return "VehicleRegisterDetailsModel [vehicleRegisterId=" + vehicleRegisterId + ", vehicleOwnerId="
				+ vehicleOwnerId + ", registerDate=" + registerDate + ", registerCenter=" + registerCenter
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", vehicleRegisterNumber="
				+ vehicleRegisterNumber + "]";
	}
	
	
	
	

}
