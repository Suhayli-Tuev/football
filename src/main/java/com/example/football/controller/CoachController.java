package com.example.football.controller;

import com.example.football.dto.CoachDto;
import com.example.football.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coaches")
public class CoachController {
    private final CoachService coachService;

    @GetMapping
    public ResponseEntity<?> getCoaches() {
        return coachService.getCoaches();
    }

    @PostMapping
    public ResponseEntity<?> createCoach(CoachDto coachDto) {
        return coachService.createCoach(coachDto);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCoach(@RequestParam Long coachId) {
        return coachService.deleteCoach(coachId);
    }
}
