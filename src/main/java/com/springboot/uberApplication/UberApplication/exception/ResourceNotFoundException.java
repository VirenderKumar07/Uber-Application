package com.springboot.uberApplication.UberApplication.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
