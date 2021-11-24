package com.malanukha.exceptions;

import org.springframework.http.HttpStatus;

public class UnregisteredUserException extends GameException {

    public UnregisteredUserException(ExceptionMessage message) {
        super(message.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
