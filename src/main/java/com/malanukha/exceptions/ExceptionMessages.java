package com.malanukha.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionMessages {

    GAME_ALREADY_STARTED("Game has already started!"),
    WRONG_USER_DATA("Incorrect user data.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

}
