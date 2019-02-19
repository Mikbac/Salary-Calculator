package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCountryIdException extends RuntimeException{
    public InvalidCountryIdException() {
        super("This country code does not exist!");
    }
}
