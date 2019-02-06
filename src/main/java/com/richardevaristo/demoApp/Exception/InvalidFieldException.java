package com.richardevaristo.demoApp.Exception;

public class InvalidFieldException extends RuntimeException{

    private String message;

    public InvalidFieldException(String message) {
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
