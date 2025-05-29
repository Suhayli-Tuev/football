package com.example.football.mapper;

import com.example.football.db.model.Coach;
import com.example.football.dto.CoachDto;

public class CoachMapper {
    public static Coach toCoach(CoachDto coachDto) {
        Coach coach = new Coach();
        coach.setName(coachDto.getName());
        coach.setSurname(coachDto.getSurname());

        return coach;
    }
}
