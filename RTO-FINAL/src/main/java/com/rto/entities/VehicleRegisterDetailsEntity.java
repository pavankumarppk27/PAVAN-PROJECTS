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

public class VehicleRegisterDetailsEntity {

	@Column
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "vh_reg_det", sequenceName = "vh_reg_det", initialValue = 1, allocationSize = 1)
	  @GeneratedValue(generator = "vh_reg_det")

	private Long vehicleRegisterId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_owner_id" ,referencedColumnName="vehicle_owner_id")
	private VehicleOwnerDetailsEntity vehicleOwnerId;
	@Column
	private Date registerDate;
	@Column
	private String registerCenter;
	
	@Column
	@CreationTimestamp
	private Date createDate;
	@Column
	@UpdateTimestamp
	private Date updateDate;
	@Column
	private String vehicleRegisterNumber;
	public Long getVehicleRegisterId() {
		return vehicleRegisterId;
	}
	public void setVehicleRegisterId(Long vehicleRegisterId) {
		this.vehicleRegisterId = vehicleRegisterId;
	}
	public VehicleOwnerDetailsEntity getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(VehicleOwnerDetailsEntity vehicleOwnerId) {
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
	
 
}
