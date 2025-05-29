package com.example.football.controller;

import com.example.football.dto.TeamDto;
import com.example.football.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<?> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public ResponseEntity<?> createTeam(TeamDto teamDto) {
        return teamService.createTeam(teamDto);
    }

    @PostMapping("/{teamId}/players")
    public ResponseEntity<?> addPlayerToTeamById(@PathVariable Long teamId, @RequestParam Long playerId) {
        return teamService.addPlayerToTeamById(teamId, playerId);
    }

    @PostMapping("/{teamId}/coaches")
    public ResponseEntity<?> addCoachToTeamById(@PathVariable Long teamId, @RequestParam Long coachId) {
        return teamService.addCoachToTeamById(teamId, coachId);
    }
}
