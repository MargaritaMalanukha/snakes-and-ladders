package com.malanukha.controller;

import com.malanukha.dto.ErrorDto;
import com.malanukha.exceptions.GameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(value = GameException.class)
    protected ResponseEntity<ErrorDto> handleGameException(GameException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDto(ex.getMessage()));
    }
}