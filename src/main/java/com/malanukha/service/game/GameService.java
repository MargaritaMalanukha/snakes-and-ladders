package com.malanukha.service.game;

import com.malanukha.dto.GameInfoDto;

public interface GameService {

    GameInfoDto register(String userName);
    GameInfoDto makeMove();
}