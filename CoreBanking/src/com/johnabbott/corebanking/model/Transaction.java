package com.johnabbott.corebanking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionId")
	private int transacionId;

	@Column(name = "transDate", nullable = false)
	private Date transDate;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "transType")
	private String transType;
	
	@Column(name = "direction")
	private String direction;

	public Transaction() {
		
	}


	public int getTransacionId() {
		return transacionId;
	}


	public void setTransacionId(int transacionId) {
		this.transacionId = transacionId;
	}


	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}