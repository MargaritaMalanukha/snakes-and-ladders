package com.malanukha.service.game;

import com.malanukha.dto.GameInfoDto;
import com.malanukha.exceptions.ExceptionMessages;
import com.malanukha.exceptions.UnregisteredUserException;
import com.malanukha.service.move.MoveGenerator;
import com.malanukha.service.register.RegistrationValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private final MoveGenerator moveGenerator;
    private final RegistrationValidator registrationValidator;
    private final GameInfoHolder gameInfoHolder;

    @Override
    public GameInfoDto register(String userName) {
        if (gameInfoHolder.isGameFinished()) {
            gameInfoHolder.refreshGameInfoDto();
        }

        registrationValidator.validate(gameInfoHolder, userName);
        gameInfoHolder.setUserName(userName);

        return gameInfoHolder.getGameInfoDto();
    }

    @Override
    public GameInfoDto makeMove() {
        if (gameInfoHolder.isGameFinished()){
            return gameInfoHolder.getGameInfoDto();
        }

        if (gameInfoHolder.getUserName() == null) {
            throw new UnregisteredUserException(ExceptionMessages.UNREGISTERED_USER);
        }

        gameInfoHolder.setGameStarted(true);
        moveGenerator.makeMove(gameInfoHolder);

        return gameInfoHolder.getGameInfoDto();
    }
}