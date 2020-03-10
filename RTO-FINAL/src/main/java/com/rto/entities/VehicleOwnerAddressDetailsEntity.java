package com.rto.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class VehicleOwnerAddressDetailsEntity {

	@Column
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	@SequenceGenerator(name = "vh_own_add_det", sequenceName = "vh_own_add_det", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "vh_own_add_det")
	private Long addressId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_owner_id" ,referencedColumnName="vehicle_owner_id")
	private VehicleOwnerDetailsEntity vehicleOwnerId;
	@Column
	private String houseNo;
	@Column
	private String streetName;
	@Column
	private String city;
	@Column
	private Long zipCode;
	@Column
	@CreationTimestamp
	private Date createDate;
	@Column
	@UpdateTimestamp
	private Date updateDate;
	
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public VehicleOwnerDetailsEntity getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(VehicleOwnerDetailsEntity vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
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
	
	
	
	
	
	
	

}
