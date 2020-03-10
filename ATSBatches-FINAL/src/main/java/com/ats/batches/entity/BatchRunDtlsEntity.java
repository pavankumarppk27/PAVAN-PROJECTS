package com.ats.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="BATCH_RUN_DTLS ")
public class BatchRunDtlsEntity {
	@Id
	@Column(name="RUN_ID ")
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BTCH_RUN_DTLS")
    @SequenceGenerator(sequenceName = "BTCH_RUN_DTLS", allocationSize = 1, name = "BTCH_RUN_DTLS")

	private Long runId ;
	
	@Column(name="BATCH_NAME")
	private  String batchName;

	@Column(name="START_DT")
	private Date startDate;

	@Column(name="RUN_STATUS")
	private String runStatus;

	@Column(name="END_DT")
	private Date endDate;

	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createDate ;

	@Column(name=" UPDATE_DT")
	@UpdateTimestamp
	private Date updatedDate;

	@Column(name=" UPDATED_BY")
	private String updatedBy;

	@Column(name="CREATE_BY")
	private String createdBy;

		
		
	
	
}
