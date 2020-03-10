package com.rto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class VehicleOwnerDetailsEntity {
	// @Column(name = "vehicle_owner_id")
	// @GeneratedValue(strategy=GenerationType.IDENTITY)

	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@SequenceGenerator(name = "vh_own_det", sequenceName = "vh_own_det", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "vh_own_det", strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_owner_id")
	private Long vehicleOwnerId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String gender;
	@Column
	private String email;
	@Column
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	@Column
	private Long phoneNumber;
	@Column
	@CreationTimestamp
	private Date createDate;
	@Column
	@UpdateTimestamp
	private Date updateDate;

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
