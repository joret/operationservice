package com.bloomberg.server.arithmeticservice.businesslogic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadParametersException extends Exception{
    public BadParametersException(){

    }

    public BadParametersException(String message){
        super(message);
    }
}
