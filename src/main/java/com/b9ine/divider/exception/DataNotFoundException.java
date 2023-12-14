package com.b9ine.divider.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super("Data cannot be found");
    }
}
