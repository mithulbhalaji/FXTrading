package com.finzly.fxtrading.exception;

public class CurrencyPairNotFoundException extends RuntimeException {
	public CurrencyPairNotFoundException(String currencyPair) {
        super("Currency pair not found: " + currencyPair);
    }
}
