package com.example.fitnessapp.controller

import com.example.fitnessapp.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/users")
class UserController (private val userRepository: UserRepository) {

    @get:GetMapping
    val allUsers: kotlin.collections.List<com.example.fitnessapp.model.User>
        get() = userRepository.findAll()

    @PostMapping fun createUser(@RequestBody user: com.example.fitnessapp.model.User): com.example.fitnessapp.model.User {
        return userRepository.save(user)
    }

    @GetMapping("/{id}") fun getUserById(@PathVariable id: Long): ResponseEntity<com.example.fitnessapp.model.User> {
        return userRepository.findById(id)
            .map<ResponseEntity<com.example.fitnessapp.model.User>> { body: com.example.fitnessapp.model.User? ->
                ResponseEntity.ok(
                    body
                )
            }
            .orElse(ResponseEntity.notFound().build())
    }
}