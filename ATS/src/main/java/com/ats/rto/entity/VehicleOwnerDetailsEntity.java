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
public class VehicleOwnerDetailsEntity {
	@Id
	//@SequenceGenerator(name = "vh_own_det", sequenceName = "vh_own_det", initialValue = 1, allocationSize = 1)
	//@GeneratedValue(generator = "vh_own_det", strategy = GenerationType.IDENTITY)
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

}
