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
public class VehicleDetailsEntity {

	@Column
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "vh_det", sequenceName = "vh_det", initialValue = 1, allocationSize = 1)
	  @GeneratedValue(generator = "vh_det")
	private Long vehicleDetailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_owner_id", referencedColumnName = "vehicle_owner_id")
	private VehicleOwnerDetailsEntity vehicleOwnerId;

	@Column
	private String vehicleType;
	@Column
	private Integer mfgYear;
	@Column
	private String vehicleBrand;
	@Column
	@CreationTimestamp
	private Date createDate;
	@Column
	@UpdateTimestamp
	private Date updateDate;

	public VehicleOwnerDetailsEntity getVehicleOwnerId() {
		return vehicleOwnerId;
	}

	public void setVehicleOwnerId(VehicleOwnerDetailsEntity vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}

	public Long getVehicleDetailId() {
		return vehicleDetailId;
	}

	public void setVehicleDetailId(Long vehicleDetailId) {
		this.vehicleDetailId = vehicleDetailId;
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
