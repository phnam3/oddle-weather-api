package com.example.oddleweatherapi.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    private String message;

    public BadRequestException(String msg){
        super(msg);
        this.message = msg;
    }

}
