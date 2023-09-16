package com.finzly.fxtrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * CurrencyPair pojo file 
 */

@Entity
public class CurrencyPair {

	@Id
	private String currencyPair;
	private double rate;

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double value) {
		this.rate = value;
	}

	@Override
	public String toString() {
		return "CurrencyPair [currencyPair=" + currencyPair + ", rate=" + rate + "]";
	}

}
