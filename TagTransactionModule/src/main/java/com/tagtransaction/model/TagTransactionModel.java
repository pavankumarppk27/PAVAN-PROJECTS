package com.tagtransaction.model;

import java.util.Date;

import lombok.Data;

@Data
public class TagTransactionModel {
	
	private Long txId;
	private String tagRegId;
	private String vehicleRegNo;
	private Long tollPlazaId;
	private Double tollPlazaAmount;
	private String transactionStatus;
	private String transactionFailureReason;
	private Date createdDate;
	private Date updatedDate;

}
