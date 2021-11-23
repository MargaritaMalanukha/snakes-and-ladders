package com.malanukha.service.register;

import com.malanukha.service.game.GameInfoHolder;

public interface RegistrationValidator {

    void validate(GameInfoHolder gameInfoHolder, String userName);
}