package com.malanukha.exceptions;

import org.springframework.http.HttpStatus;

public class GameAlreadyStartedException extends GameException {

    public GameAlreadyStartedException(ExceptionMessages message) {
        super(message.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
