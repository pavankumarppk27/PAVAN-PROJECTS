package com.rto.model;

import java.util.Date;

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

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Long getVehicleOwnerId() {
		return vehicleOwnerId;
	}

	public void setVehicleOwnerId(Long vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return "VehicleOwnerDetailsModel [vehicleOwnerId=" + vehicleOwnerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", email=" + email + ", dob=" + dob + ", phoneNumber=" + phoneNumber
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
