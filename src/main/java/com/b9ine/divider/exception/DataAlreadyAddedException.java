package com.b9ine.divider.exception;

public class DataAlreadyAddedException extends RuntimeException {
    public DataAlreadyAddedException() {
        super("Data is already added in the db, please try again with a new set of data");
    }
}
