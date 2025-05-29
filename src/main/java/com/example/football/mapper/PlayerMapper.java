package com.example.football.mapper;

import com.example.football.db.model.Player;
import com.example.football.dto.PlayerDto;

public class PlayerMapper {
    public static Player toPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setNumber(playerDto.getNumber());
        player.setName(playerDto.getName());
        player.setSurname(playerDto.getSurname());

        return player;
    }
}
