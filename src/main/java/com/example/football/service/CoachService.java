package com.example.football.service;

import com.example.football.db.model.Coach;
import com.example.football.db.repository.CoachRepository;
import com.example.football.dto.CoachDto;
import com.example.football.mapper.CoachMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;

    public ResponseEntity<?> getCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    public ResponseEntity<?> createCoach(CoachDto coachDto) {
        Coach coach = CoachMapper.toCoach(coachDto);
        coachRepository.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCoach(Long coachId) {
        Optional<Coach> coach = coachRepository.findById(coachId);
        if (coach.isPresent()) {
            coachRepository.deleteById(coachId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("No such coach", HttpStatus.NOT_FOUND);
    }
}
