package com.example.restproject.controller;

import com.example.restproject.entity.UserEntity;
import com.example.restproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.badRequest().body("User with that name already exist");
            }
            userRepo.save(user);
            return ResponseEntity.ok("The user has been successfully saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("The server is running!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}