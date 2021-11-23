package com.malanukha.service.register


import com.malanukha.exceptions.GameAlreadyStartedException
import com.malanukha.exceptions.WrongUserDataException
import com.malanukha.service.game.GameInfoHolder
import spock.lang.Specification

class RegistrationValidatorSpec extends Specification {

    private RegistrationValidator validator = new RegistrationValidatorImpl()
    private GameInfoHolder gameInfoHolder = Mock()

    private static final String defaultUserName = "userName"

    def setup() {
        0 * _
    }

    def "validate when all is correct"() {
        when:
        validator.validate(gameInfoHolder, defaultUserName)

        then:
        1 * gameInfoHolder.isGameStarted() >> false
        and:
        noExceptionThrown()
    }

    def "validate when userName is null or game has been already started"() {
        when:
        validator.validate(gameInfoHolder, userName)

        then:
        invocationTimes * gameInfoHolder.isGameStarted() >> gameStarted
        and:
        def error = thrown(expectedException)
        error.message == expectedMessage

        where:
        gameStarted  | userName          | invocationTimes || expectedException           | expectedMessage
        true         | defaultUserName   | 1               || GameAlreadyStartedException | "Game has already started!"
        false        | null              | 0               || WrongUserDataException      | "Incorrect user data."
    }
}