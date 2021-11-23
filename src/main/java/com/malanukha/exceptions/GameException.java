package com.malanukha.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GameException extends RuntimeException {

    private final HttpStatus httpStatus;

    public GameException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
