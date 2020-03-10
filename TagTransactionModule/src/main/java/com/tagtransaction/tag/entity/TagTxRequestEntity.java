package com.tagtransaction.tag.entity;

import lombok.Data;

@Data
public class TagTxRequestEntity {
	
	
	private String tagRegId;
	
    private String vehRegNum;
	
    private String tollPlazaId;
	
	private Double tollAmt;


}
