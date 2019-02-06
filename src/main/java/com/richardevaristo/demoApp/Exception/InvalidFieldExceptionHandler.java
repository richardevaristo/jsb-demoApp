package com.richardevaristo.demoApp.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidFieldExceptionHandler {

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException exception) {
        return exception.getMessage();
    }
}
