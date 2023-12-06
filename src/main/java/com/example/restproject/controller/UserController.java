package com.example.restproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("The server is running!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}