package com.ats.rto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class VehicleDetailsEntity {

	@Column
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "vh_det", sequenceName = "vh_det", initialValue = 1, allocationSize = 1)
	//@GeneratedValue(generator = "vh_det")
	private Long vehicleDetailId;

	@Column
	private Long vehicleOwnerId;

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

	
}
