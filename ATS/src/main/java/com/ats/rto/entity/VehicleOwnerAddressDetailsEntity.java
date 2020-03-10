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
public class VehicleOwnerAddressDetailsEntity {

	@Column
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)

	//@SequenceGenerator(name = "vh_own_add_det", sequenceName = "vh_own_add_det", initialValue = 1, allocationSize = 1)
	//@GeneratedValue(generator = "vh_own_add_det")
	private Long addressId;
	@Column
	private Long vehicleOwnerId;
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

	
}
