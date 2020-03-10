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
@Table(name="BATCH_RUN_SUMMARY ")
public class BatchRunSummaryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BTCH_RUN_SUMM_DTLS")
    @SequenceGenerator(sequenceName = "BTCH_RUN_SUMM_DTLS", allocationSize = 1, name = "BTCH_RUN_SUMM_DTLS")

	private Long summaryId ;
	
	@Column(name="BATCH_NAME")
	private  String batchName;

	@Column(name="SUMMARY_DTLS")
	private String summaryDtls
	;

	@Column(name="RUN_STATUS")
	private String runStatus;

	@Column(name="END_DT")
	private Date endDate;

	@CreationTimestamp
	@Column(name="CREATE_DT")
	private Date createDate ;

	@UpdateTimestamp
	@Column(name=" UPDATE_DT")
	private Date updateDate;

	@Column(name=" UPDATED_BY")
	private String updatedBy;

	@Column(name="CREATE_BY")
	private String createdBy;
	
	
	
}
