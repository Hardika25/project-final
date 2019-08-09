package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mywallet {
	
	
	@Id
	Long mobile;
	@Column
	Integer  aid;
	@Column
	String accountholder;
	@Column
	Double balance;
	public Mywallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mywallet(Long mobile, Integer aid, String accountholder, Double balance) {
		super();
		this.mobile = mobile;
		this.aid = aid;
		this.accountholder = accountholder;
		this.balance = balance;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAccountholder() {
		return accountholder;
	}
	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
}