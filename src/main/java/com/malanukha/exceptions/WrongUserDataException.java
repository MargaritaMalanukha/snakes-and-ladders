package com.malanukha.exceptions;

import org.springframework.http.HttpStatus;

public class WrongUserDataException extends GameException {

    public WrongUserDataException(ExceptionMessage message) {
        super(message.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
