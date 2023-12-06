package com.example.restproject.controller;

import com.example.restproject.entity.UserEntity;
import com.example.restproject.exception.UserAlreadyExistException;
import com.example.restproject.repository.UserRepo;
import com.example.restproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("The user has been successfully saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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