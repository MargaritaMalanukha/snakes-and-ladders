package com.malanukha.service.move;

import com.malanukha.service.game.GameInfoHolder;

public interface MoveGenerator {
    void makeMove(GameInfoHolder gameInfoHolder);
}