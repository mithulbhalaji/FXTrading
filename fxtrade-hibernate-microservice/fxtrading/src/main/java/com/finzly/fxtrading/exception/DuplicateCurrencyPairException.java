package com.finzly.fxtrading.exception;

public class DuplicateCurrencyPairException extends RuntimeException {
    public DuplicateCurrencyPairException() {
        super("The currency pair already exists ");
    }
}
