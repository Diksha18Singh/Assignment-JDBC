package com.JDBCassign;

import java.io.Serializable;
import java.sql.Date;

public class Card implements Serializable {

	private int id;
	private Date expiry;
	private int customer_id;
	private float balance;
	private float credit_limit;

	public Card() {
		super();
	}

	public Card(int id, Date expiry, int customer_id, float balance, float credit_limit) {
		super();
		this.id = id;
		this.expiry = expiry;
		this.customer_id = customer_id;
		this.balance = balance;
		this.credit_limit = credit_limit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(float credit_limit) {
		this.credit_limit = credit_limit;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", expiry=" + expiry + ", customer_id=" + customer_id + ", balance=" + balance
				+ ", credit_limit=" + credit_limit + "]";
	}

}
