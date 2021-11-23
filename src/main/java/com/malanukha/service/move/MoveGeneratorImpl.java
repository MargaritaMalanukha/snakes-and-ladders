package com.malanukha.service.move;

import com.malanukha.service.game.GameInfoHolder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MoveGeneratorImpl implements MoveGenerator {

    private static final int MIN = 1;
    private static final int MAX = 6;
    private static final int MAX_CELL = 100;
    private final Random random;

    public MoveGeneratorImpl(Random random) {
        this.random = random;
    }

    @Override
    public void makeMove(GameInfoHolder gameInfoHolder) {
        int currentScore = random.nextInt(MAX - MIN + 1) + MIN + gameInfoHolder.getCurrentScore();

        if (currentScore <= MAX_CELL) {
            gameInfoHolder.setCurrentScore(currentScore);
        }
        gameInfoHolder.setGameFinished(currentScore == MAX_CELL);
    }
}