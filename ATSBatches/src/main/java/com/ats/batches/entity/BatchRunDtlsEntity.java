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
@Table(name="BATCH_RUN_DTLS ")
public class BatchRunDtlsEntity {
	@Id
	@Column(name="RUN_ID ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long RUN_ID ;
	
	@Column(name="BATCH_NAME")
	private  String BATCH_NAME;

	@Column(name="START_DT")
	private Date START_DT;

	@Column(name="RUN_STATUS")
	private String RUN_STATUS;

	@Column(name="END_DT")
	private Date END_DT;

	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date CREATE_DT ;

	@Column(name=" UPDATE_DT")
	@UpdateTimestamp
	private Date UPDATE_DT;

	@Column(name=" UPDATED_BY")
	private String UPDATED_BY;

	@Column(name="CREATE_BY")
	private String CREATE_BY;

		
		
	
	
}
