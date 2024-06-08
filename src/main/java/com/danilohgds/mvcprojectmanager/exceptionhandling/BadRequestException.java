package com.danilohgds.mvcprojectmanager.exceptionhandling;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
