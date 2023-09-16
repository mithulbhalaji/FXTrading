package com.finzly.fxtrading.exception;

public class InvalidAmountException   extends RuntimeException{
	public InvalidAmountException(double amount) {
        super("Not a valid amount : " + amount);
    }
}
