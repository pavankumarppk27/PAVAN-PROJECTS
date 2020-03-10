package com.tagtransaction.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TagTxResponseModel {
	
	
	@XmlElement
	private String tagRegId;
	@XmlElement
	private String txStatus;
	@XmlElement
	private String vehRegNo;
	@XmlElement
	private String failureReason;

}
