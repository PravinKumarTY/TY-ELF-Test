package com.tyss.library.management.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="user_info")
@Data
public class UserInfoDto {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	@Column(name ="user_name",nullable=false)
	private String userName;
	@Column(name ="user_contact_no",unique=true)
	private long userContactNo;
	@Column(name = "user_email",unique=true)
	private String userEmail;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "user_role")
	private String userRole;
	@Column(name = "user_gender")
	private String userGender;
}
