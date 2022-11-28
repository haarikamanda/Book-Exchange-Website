package com.Web.BookExchange.entity;
//import java.util.*;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="NormalUser")

public class NormalUser {
	
	@Id
	@Column(name="id")
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="role")
	private String role = "ROLE_USER";
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="userName")
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="name")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="phone")
	private String phone;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="enabled")
	private Boolean enabled;
	
	public Boolean getenabled() {
		return enabled;
	}
	public void setenabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Column(name="address")
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public NormalUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NormalUser(Long userId, String role, String userName, String password, String name, String email,
			String phone, Boolean enabled, String address) {
		super();
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.address = address;
	}
	
	
	
	
}
