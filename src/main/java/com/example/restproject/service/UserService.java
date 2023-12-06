package com.example.restproject.service;

import com.example.restproject.entity.UserEntity;
import com.example.restproject.exception.UserAlreadyExistException;
import com.example.restproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw  new UserAlreadyExistException("User with that name already exist");
        }
       return userRepo.save(user);
    }
}
