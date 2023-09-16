package com.finzly.fxtrading.exception;

public class InvalidCurrencyPairException extends RuntimeException{
	public InvalidCurrencyPairException(String currencyPair) {
        super("Invalid currency pair: " + currencyPair);
    }
}
