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
	private Long trgId ;
	
	@Column
	private Long tagId;

	@Column(name="VHCL_REG_NUM")
	private  String vhclRegNum;

	@Column(name="TOLL_PLAZA_ID")
	private String tollPlazaId;

	@Column(name="TOLL_AMT")
	private long tollAmt;

	@Column(name="TX_STATUS")
	private  String txStatus;

	@Column(name="TX_FAILURE_RSN")
	private String txFailureRsn;
	
	@Column(name="REMINDER_MSG_SW")
	private String  reminderMsgSw;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createDate ;

	@UpdateTimestamp
	@Column(name=" UPDATE_DT")
	private Date updateDate;

	@Column(name=" UPDATED_BY")
	private String updatedBy;

	@Column(name="CREATE_BY")
	private String createdBy;
		
		
	

	}
	

