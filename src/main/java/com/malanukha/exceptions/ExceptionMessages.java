package com.malanukha.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionMessages {

    GAME_ALREADY_STARTED("Game has already started!"),
    UNREGISTERED_USER("You are unregistered in game. To register, make a POST request on this root."),
    WRONG_USER_DATA("Incorrect user data.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

}
