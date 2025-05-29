package com.example.football.service;

import com.example.football.db.model.Player;
import com.example.football.db.repository.PlayerRepository;
import com.example.football.dto.PlayerDto;
import com.example.football.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public ResponseEntity<?> getPlayers() {
        List<Player> players = playerRepository.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    public ResponseEntity<?> createPlayer(PlayerDto playerDto) {
        Player player = PlayerMapper.toPlayer(playerDto);
        playerRepository.save(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
