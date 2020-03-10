package com.tagtransaction.tag.entity;

import lombok.Data;


@Data
public class TagTxResponseEntity {
	
	
	
	private Long tagId;
	
	private String txStatus;
	
	private String vehRegNo;
	
	private String failureReason;

}
