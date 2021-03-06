package com.tagtransaction.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TagTxRequestModel {
	
	@XmlElement
	private String tagRegId;
	@XmlElement
    private String vehRegNum;
	@XmlElement
    private String tollPlazaId;
	@XmlElement
	private Double tollAmt;


}
