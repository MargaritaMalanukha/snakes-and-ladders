package com.malanukha.service.move


import com.malanukha.service.game.GameInfoHolder
import spock.lang.Specification

class MoveGeneratorSpec extends Specification {

    private Random random = Mock()
    private GameInfoHolder gameInfoHolder = Mock()

    private MoveGenerator moveGenerator = new MoveGeneratorImpl(random)

    private static final int bound = 6;

    def setup() {
        0 * _
    }

    def "generates move and sets new currentScore"() {
        when:
        moveGenerator.makeMove(gameInfoHolder)

        then:
        1 * random.nextInt(bound) >> 5
        1 * gameInfoHolder.getCurrentScore() >> initialScore
        1 * gameInfoHolder.setCurrentScore(newScore)
        1 * gameInfoHolder.setGameFinished(gameFinished)

        where:
        initialScore | gameFinished || newScore
        3            | false        || 9
        94           | true         || 100
    }

    def "generates move but does not set score which is bigger than board size"() {
        int score = 99

        when:
        moveGenerator.makeMove(gameInfoHolder)

        then:
        1 * random.nextInt(bound) >> 5
        1 * gameInfoHolder.getCurrentScore() >> score
        1 * gameInfoHolder.setGameFinished(false)
    }
}
