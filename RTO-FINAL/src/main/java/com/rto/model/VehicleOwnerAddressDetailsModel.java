package com.rto.model;

import java.util.Date;

public class VehicleOwnerAddressDetailsModel {

	private Long addressId;
	private Long vehicleOwnerId;
	private String houseNo;
	private String streetName;
	private String city;
	private Long zipCode;
	private Date createDate;
	private Date updateDate;
	
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Long getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(Long vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
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
	@Override
	public String toString() {
		return "VehicleOwnerAddressDetailsModel [addressId=" + addressId + ", vehicleOwnerId=" + vehicleOwnerId
				+ ", houseNo=" + houseNo + ", streetName=" + streetName + ", city=" + city + ", zipCode=" + zipCode
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	
	
	
}
