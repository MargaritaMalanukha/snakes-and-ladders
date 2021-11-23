package com.malanukha.service.game

import com.malanukha.dto.GameInfoDto
import com.malanukha.dto.UserDto
import com.malanukha.exceptions.UnregisteredUserException
import com.malanukha.service.move.MoveGenerator
import com.malanukha.service.register.RegistrationValidator
import spock.lang.Specification

class GameServiceSpec extends Specification {

    private MoveGenerator moveGenerator = Mock()
    private RegistrationValidator registrationValidator = Mock()
    private GameInfoHolder gameInfoHolder = Mock()

    private GameService gameService = new GameServiceImpl(moveGenerator, registrationValidator, gameInfoHolder)

    private static final String userName = "userName"

    def setup() {
        0 * _
    }

    def "register - set userName after successful registration"() {
        when:
        GameInfoDto gameInfoDto = gameService.register(userName)

        then:
        1 * gameInfoHolder.isGameFinished() >> false
        1 * registrationValidator.validate(gameInfoHolder, userName)
        1 * gameInfoHolder.setUserName(userName)
        1 * gameInfoHolder.getGameInfoDto() >> createGameInfoDtoWithUserName(userName)
        and:
        userName == gameInfoDto.userDto.userName
    }

    def "register - when game is finished, start new game"() {
        when:
        GameInfoDto gameInfoDto = gameService.register(userName)

        then:
        1 * gameInfoHolder.isGameFinished() >> true
        1 * gameInfoHolder.refreshGameInfoDto()
        1 * registrationValidator.validate(gameInfoHolder, userName)
        1 * gameInfoHolder.setUserName(userName)
        1 * gameInfoHolder.getGameInfoDto() >> createGameInfoDtoWithUserName(userName)
        and:
        !gameInfoDto.gameFinished
    }

    def "makeMove - when userName is null, throw UnregisteredUserException"() {
        when:
        gameService.makeMove()

        then:
        1 * gameInfoHolder.isGameFinished() >> false
        1 * gameInfoHolder.getUserName() >> null
        and:
        thrown UnregisteredUserException
    }

    def "makeMove - when game is finished, return gameInfo without changes" () {
        given:
        def finishedGame = finishedGame()

        when:
        GameInfoDto gameInfoDto = gameService.makeMove()

        then:
        1 * gameInfoHolder.isGameFinished() >> true
        1 * gameInfoHolder.getGameInfoDto() >> finishedGame
        and:
        gameInfoDto == finishedGame
    }

    def "makeMove - when game is new, start game and make first move"() {
        given:
        def startedGame = startedGame()

        when:
        GameInfoDto gameInfoDto = gameService.makeMove()

        then:
        1 * gameInfoHolder.isGameFinished() >> false
        1 * gameInfoHolder.getUserName() >> userName
        1 * gameInfoHolder.setGameStarted(true)
        1 * moveGenerator.makeMove(gameInfoHolder)
        1 * gameInfoHolder.getGameInfoDto() >> startedGame
        and:
        gameInfoDto == startedGame
    }

    private static GameInfoDto startedGame(){
        return GameInfoDto.builder()
                .gameStarted(true)
                .build()
    }

    private static GameInfoDto finishedGame() {
        return GameInfoDto.builder()
                .gameFinished(true)
                .build()
    }

    private static GameInfoDto createGameInfoDtoWithUserName(String userName) {
        GameInfoDto.builder()
                .userDto(new UserDto(userName, 0))
                .build()
    }
}
