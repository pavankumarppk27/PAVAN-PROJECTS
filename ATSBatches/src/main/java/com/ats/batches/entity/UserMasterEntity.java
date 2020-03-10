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
@Table(name="USER_MASTER")
public class UserMasterEntity {

@Id
@Column(name="USER_ID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long USER_ID;

@Column(name="FIRST_NAME")
private  String FIRST_NAME;

@Column(name="LAST_NAME")
private String LAST_NAME;

@Column(name="Email_ID")
private String Email_ID;

@Column(name="MOBILE_NUM")
private Long MOBILE_NUM;

@Column(name="GENDER")
private String GENDER;

@Column(name="CREATE_DT")
@CreationTimestamp
private Date CREATE_DT ;

@UpdateTimestamp
@Column(name=" UPDATE_DT")
private Date UPDATE_DT;

@Column(name=" UPDATED_BY")
private String UPDATED_BY;

@Column(name="CREATE_BY")
private String CREATE_BY;
	
	
}
