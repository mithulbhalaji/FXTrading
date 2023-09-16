package com.finzly.fxtrading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Trade pojo class
 */

@Entity
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeno;
	private String customerName;
	private String currencyPair;
	private double amount;
	private double rate;
	private double convertedAmount;

	public int getTradeno() {
		return tradeno;
	}

	public void setTradeno(int tradeno) {
		this.tradeno = tradeno;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double amountRate) {
		this.convertedAmount = amountRate;
	}

	@Override
	public String toString() {
		return "Trade [tradeno=" + tradeno + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amount=" + amount + ", rate=" + rate + ", convertedAmount=" + convertedAmount + "]";
	}
	
}