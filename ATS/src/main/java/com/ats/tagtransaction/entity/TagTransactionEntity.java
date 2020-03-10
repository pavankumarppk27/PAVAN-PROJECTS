package com.ats.tagtransaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Tag_Transaction_Details")
public class TagTransactionEntity {

	@Id
	@SequenceGenerator(name = "TAG_TX_SEQ", sequenceName = "TAG_TX_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "TAG_TX_SEQ")
	@Column(name = "TX_ID")
	private Long transactionId;
		
	@Column(name = "TAG_ID")
	private String tagRegId;
	
	@Column(name = "VHCL_REG_NUM")
	private String vehicleRegNo;
	
	@Column(name="TOLL_PLAZA_ID")
	private String tollPlazaId;
	
	@Column(name="TOLL_AMT")
	private Double tollPlazaAmount;
	
	@Column(name="TX_STATUS")
	private String transactionStatus;
	
	@Column(name="TX_FAILURE_RSN")
	private String transactionFailureReason;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updatedDate;

}
