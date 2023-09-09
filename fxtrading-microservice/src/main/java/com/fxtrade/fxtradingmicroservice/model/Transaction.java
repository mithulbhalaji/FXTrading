package com.fxtrade.fxtradingmicroservice.model;

public class Transaction {
	private String customerName;
    private String currencyPair;
    private double amount;
    private double rate;
    private int tradeno;
    
    public Transaction() {
	}

    public Transaction(String customerName, String currencyPair, double amount) {
        this.customerName = customerName;
        this.currencyPair = currencyPair;
        this.amount = amount;
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


	public int getTradeno() {
		return tradeno;
	}

	public void setTradeno(int tradeno) {
		this.tradeno = tradeno;
	}	
}
