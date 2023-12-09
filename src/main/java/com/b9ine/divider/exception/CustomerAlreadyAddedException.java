package com.b9ine.divider.exception;

import com.b9ine.divider.model.Booker;

public class CustomerAlreadyAddedException extends RuntimeException{
	public CustomerAlreadyAddedException(Booker b) {
		super("Account is already created with this email, please try again using different email: " + b);
	}
}
