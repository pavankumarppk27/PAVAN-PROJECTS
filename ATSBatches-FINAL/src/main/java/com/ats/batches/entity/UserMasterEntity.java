package com.ats.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
private Long userId;

@Column(name="FIRST_NAME")
private  String firstName;

@Column(name="LAST_NAME")
private String lastName;

@Column(name="Email_ID")
private String emailId;

@Column(name="MOBILE_NUM")
private Long mobileNum;

@Column(name="GENDER")
private String gender;


@Column(name="CREATE_DT")
@CreationTimestamp
private Date createDate ;

@UpdateTimestamp
@Column(name=" UPDATE_DT")
private Date updateDate;

@Column(name=" UPDATED_BY")
private String updatedBy;

@Column(name="CREATE_BY")
private String createdBy;
	
	
}
