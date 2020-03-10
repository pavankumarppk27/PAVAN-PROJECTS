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
@Table(name="BATCH_RUN_SUMMARY ")
public class BatchRunSummaryEntity {

	@Id
	@Column(name="SUMMARY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SUMMARY_ID ;
	
	@Column(name="BATCH_NAME")
	private  String BATCH_NAME;

	@Column(name="SUMMARY_DTLS")
	private String SUMMARY_DTLS
	;

	@Column(name="RUN_STATUS")
	private String RUN_STATUS;

	@Column(name="END_DT")
	private Date END_DT;

	@CreationTimestamp
	@Column(name="CREATE_DT")
	private Date CREATE_DT ;

	@UpdateTimestamp
	@Column(name=" UPDATE_DT")
	private Date UPDATE_DT;

	@Column(name=" UPDATED_BY")
	private String UPDATED_BY;

	@Column(name="CREATE_BY")
	private String CREATE_BY;
	
	
	
}
