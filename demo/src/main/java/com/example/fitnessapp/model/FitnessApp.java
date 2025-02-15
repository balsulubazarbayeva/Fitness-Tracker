package com.example.fitnessapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fitness_apps")
public class FitnessApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String version;
    private String releaseDate;
}
