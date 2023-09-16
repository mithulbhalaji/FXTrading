package com.finzly.fxtrading.exception;

public class InvalidCustomerNameException extends RuntimeException{
	public InvalidCustomerNameException(String name) {
        super("Not a valid name : " + name);
    }
}
