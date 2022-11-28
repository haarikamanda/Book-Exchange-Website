package com.Web.BookExchange.entity;


import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Wallet")

public class Wallet {
	
	@Id
	@Column(name="id")
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="amount")
	private double amount;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Wallet(Long userId, double amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
