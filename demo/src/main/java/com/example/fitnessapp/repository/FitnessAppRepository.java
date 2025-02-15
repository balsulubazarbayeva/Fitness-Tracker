package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.FitnessApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessAppRepository extends JpaRepository<FitnessApp, Long> {
}
