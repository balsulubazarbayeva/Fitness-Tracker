package com.example.fitnessapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workout_plans")
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int duration;
    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}