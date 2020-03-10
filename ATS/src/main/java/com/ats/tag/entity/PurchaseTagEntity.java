package com.ats.tag.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ats.user.entity.UserEntity;

import lombok.Data;

@Data
@Entity
@Table(name="TAG_MASTER")
public class PurchaseTagEntity {

	@Id
	@SequenceGenerator(name = "TAG_ID_SEQ", sequenceName = "TAG_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "TAG_ID_SEQ")
	@Column
	private Long tagId;
	
	@Column
	private String tagRegId;
	
	@Column
	private String vehicleRegNum;
	
	@Column
	private String vehicleType;
	
	@Column
	private Date tagStartDate;
	
	@Column
	private Date tagExpiryDate;
	
	@Column
	private Double tagBal;
	
	
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName = "userId")
	private UserEntity userId;
	
	@Column
	private String tagSwitch;
	
	@Column
	@CreationTimestamp
	private Date createdDate;
	
	@Column
	@UpdateTimestamp
	private Date updatedDate;

}
