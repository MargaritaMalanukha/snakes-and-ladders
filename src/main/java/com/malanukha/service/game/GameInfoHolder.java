package com.malanukha.service.game;

import com.malanukha.dto.GameInfoDto;
import com.malanukha.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoHolder {

    private GameInfoDto gameInfoDto;

    public void refreshGameInfoDto() {
        gameInfoDto = new GameInfoDto(new UserDto());
    }

    public void setUserName(String userName) {
        gameInfoDto.getUserDto().setUserName(userName);
    }

    public void setCurrentScore(int currentScore) {
        gameInfoDto.getUserDto().setCurrentScore(currentScore);
    }

    public void setGameStarted(boolean gameStarted) {
        gameInfoDto.setGameStarted(gameStarted);
    }

    public void setGameFinished(boolean gameFinished) {
        gameInfoDto.setGameFinished(gameFinished);
    }

    public String getUserName() {
        return gameInfoDto.getUserDto().getUserName();
    }

    public int getCurrentScore() {
        return gameInfoDto.getUserDto().getCurrentScore();
    }

    public boolean isGameStarted() {
        return gameInfoDto.isGameStarted();
    }

    public boolean isGameFinished() {
        return gameInfoDto.isGameFinished();
    }

    public GameInfoDto getGameInfoDto() {
        return gameInfoDto;
    }

    @PostConstruct
    private void initGameInfoDto() {
        refreshGameInfoDto();
    }
}