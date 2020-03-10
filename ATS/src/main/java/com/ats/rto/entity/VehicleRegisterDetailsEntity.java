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
public class VehicleRegisterDetailsEntity {

	@Column
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name = "vh_reg_det", sequenceName = "vh_reg_det", initialValue = 1, allocationSize = 1)
	  //@GeneratedValue(generator = "vh_reg_det")

	private Long vehicleRegisterId;
	
	@Column
	private Long vehicleOwnerId;
	
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
	
	
	
}
