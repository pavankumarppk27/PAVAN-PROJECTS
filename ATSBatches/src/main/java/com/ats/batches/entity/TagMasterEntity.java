package com.ats.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class TagMasterEntity {
	/*
	 * @SequenceGenerator(name = "TAG_ID_SEQ", sequenceName = "TAG_ID_SEQ",
	 * initialValue = 1, allocationSize = 1)
	 * 
	 * @GeneratedValue(generator = "TAG_ID_SEQ")
	 */	
	
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Long tagSeq;
	
	@Column
	private String tagId;
	
	@Column
	private String vehicleRegNum;
	
	@Column
	private String vehicleType;
	
	@Column
	private Date tagStartDate;
	
	@Column
	private Date tagExpiryDate;
	
	@Column
	private Double tagBal;
	
	@Column
	private Long userId;
	
	@Column
	@CreationTimestamp
	private Date createdDate;
	
	@Column
	@UpdateTimestamp
	private Date updatedDate;
	
	@Column(name=" UPDATED_BY")
	private String UPDATED_BY;

	@Column(name="CREATE_BY")
	private String CREATE_BY;
		

}
