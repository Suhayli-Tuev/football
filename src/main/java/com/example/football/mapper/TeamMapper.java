package com.example.football.mapper;

import com.example.football.db.model.Team;
import com.example.football.dto.TeamDto;

public class TeamMapper {
    public static Team toTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());

        return team;
    }
}
