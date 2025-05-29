package com.example.football.service;

import com.example.football.db.model.Coach;
import com.example.football.db.model.Player;
import com.example.football.db.model.Team;
import com.example.football.db.repository.CoachRepository;
import com.example.football.db.repository.PlayerRepository;
import com.example.football.db.repository.TeamRepository;
import com.example.football.dto.TeamDto;
import com.example.football.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final CoachRepository coachRepository;

    public ResponseEntity<?> getTeams() {
        List<Team> teams= teamRepository.findAll();

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    public ResponseEntity<?> createTeam(TeamDto teamDto) {
        Team team = TeamMapper.toTeam(teamDto);
        teamRepository.save(team);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    public ResponseEntity<?> addPlayerToTeamById(Long teamId, Long playerId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) {
            return new ResponseEntity<>("No such team", HttpStatus.NOT_FOUND);
        }
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return new ResponseEntity<>("No such player", HttpStatus.NOT_FOUND);
        }
        team.get().getPlayers().add(player.get());
        teamRepository.save(team.get());
        player.get().setTeam(team.get());
        playerRepository.save(player.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> addCoachToTeamById(Long teamId, Long coachId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) {
            return new ResponseEntity<>("No such team", HttpStatus.NOT_FOUND);
        }
        Optional<Coach> coach = coachRepository.findById(coachId);
        if (coach.isEmpty()) {
            return new ResponseEntity<>("No such coach", HttpStatus.NOT_FOUND);
        }
        team.get().setCoach(coach.get());
        teamRepository.save(team.get());
        coach.get().setTeam(team.get());
        coachRepository.save(coach.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
