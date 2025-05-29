package com.example.football.db.repository;

import com.example.football.db.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
