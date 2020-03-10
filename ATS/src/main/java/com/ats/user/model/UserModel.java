package com.ats.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserModel {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String gender;
	private String password;
	private String status;
	private String role;
	private String activeSwitch;
	private Date createDate;
	private Date updateDate;

}
