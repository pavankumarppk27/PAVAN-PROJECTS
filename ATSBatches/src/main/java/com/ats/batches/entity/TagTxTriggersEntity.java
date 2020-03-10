package com.ats.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
	
	@Data
	@Entity
	@Table(name="TAG_TX_TRIGGERS")
	public class TagTxTriggersEntity {
		
	@Id
	@Column(name="TRG_ID ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trgId ;
	
	@Column
	private Long tagId;

	@Column(name="VHCL_REG_NUM")
	private  String VHCLREGNUM;

	@Column(name="TOLL_PLAZA_ID")
	private String TOLL_PLAZA_ID;

	@Column(name="TOLL_AMT")
	private long TOLL_AMT;

	@Column(name="TX_STATUS")
	private  String TX_STATUS;

	@Column(name="TX_FAILURE_RSN")
	private String TX_FAILURE_RSN;
	
	@Column(name="REMINDERMSG_SW")
	private String  REMINDERMSG_SW;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date CREATE_DT ;

	@UpdateTimestamp
	@Column(name=" UPDATE_DT")
	private Date UPDATE_DT;

	@Column(name=" UPDATED_BY")
	private String UPDATED_BY;

	@Column(name="CREATE_BY")
	private String CREATE_BY;
		
		
	

	}
	

