package com.malanukha.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GameInfoDto {

    private UserDto userDto;

    private boolean gameStarted;
    private boolean gameFinished;

    public GameInfoDto(UserDto userDto) {
        this.userDto = userDto;
    }
}