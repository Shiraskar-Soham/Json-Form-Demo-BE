package com.example.jsonData.exceptions;

public class CustomException extends Exception {

    private Exception rootException;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Exception ex) {
        super(message, ex);
        this.rootException = ex;
    }
}