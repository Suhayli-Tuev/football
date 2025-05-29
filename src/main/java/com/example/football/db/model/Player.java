package com.example.football.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "players",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"number", "team"})
        }
)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private String name;
    private String surname;
    @ManyToOne
    @JsonIgnore
    private Coach coach;
    @ManyToOne
    @JsonIgnore
    private Team team;
}
