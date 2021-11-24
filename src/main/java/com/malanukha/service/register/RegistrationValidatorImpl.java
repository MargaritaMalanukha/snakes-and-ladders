package com.malanukha.service.register;

import com.malanukha.exceptions.ExceptionMessage;
import com.malanukha.exceptions.GameAlreadyStartedException;
import com.malanukha.exceptions.WrongUserDataException;
import com.malanukha.service.game.GameInfoHolder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationValidatorImpl implements RegistrationValidator {

    @Override
    public void validate(GameInfoHolder gameInfoHolder, String userName) {
        if (userName == null) {
            throw new WrongUserDataException(ExceptionMessage.WRONG_USER_DATA);
        }
        if (gameInfoHolder.isGameStarted()){
            throw new GameAlreadyStartedException(ExceptionMessage.GAME_ALREADY_STARTED);
        }
    }
}