package com.example.football.controller;

import com.example.football.dto.PlayerDto;
import com.example.football.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<?> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);
    }
}
