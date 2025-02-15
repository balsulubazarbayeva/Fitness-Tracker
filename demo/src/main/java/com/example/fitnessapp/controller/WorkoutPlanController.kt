package com.example.fitnessapp.controller

import com.example.fitnessapp.model.WorkoutPlan
import com.example.fitnessapp.repository.WorkoutPlanRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workout-plans")
class WorkoutPlanController(private val workoutPlanRepository: WorkoutPlanRepository) {
    @get:GetMapping
    val allWorkoutPlans: List<WorkoutPlan>
        get() = workoutPlanRepository.findAll()

    @PostMapping
    fun createWorkoutPlan(@RequestBody workoutPlan: WorkoutPlan): WorkoutPlan {
        return workoutPlanRepository.save(workoutPlan)
    }

    @GetMapping("/{id}")
    fun getWorkoutPlanById(@PathVariable id: Long): ResponseEntity<WorkoutPlan> {
        return workoutPlanRepository.findById(id)
            .map<ResponseEntity<WorkoutPlan>> { body: WorkoutPlan? -> ResponseEntity.ok(body) }
            .orElse(ResponseEntity.notFound().build())
    }
}