package com.malanukha.controller;

import com.malanukha.dto.GameInfoDto;
import com.malanukha.service.game.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameInfoDto> register(@RequestParam String userName) {
        return new ResponseEntity<>(gameService.register(userName), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<GameInfoDto> makeMove() {
        return ResponseEntity.ok(gameService.makeMove());
    }
}