package com.b9ine.divider.exception;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException() {
		super("This accound is not found, please try with other account");
	}
}
