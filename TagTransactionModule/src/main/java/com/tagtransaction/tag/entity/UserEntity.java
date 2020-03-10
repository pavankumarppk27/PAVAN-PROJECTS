package com.tagtransaction.tag.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "User_Master")
public class UserEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String email;

	@Column
	private Long phoneNumber;

	@Column
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	@Column
	private String gender;

	@Column
	private String password;

	@Column
	private String status;

	@Column
	private String role;
	
	@Column
	private String activeSwitch;

	@Column
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

}
