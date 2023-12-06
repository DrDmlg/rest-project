package com.example.restproject.service;

import com.example.restproject.entity.UserEntity;
import com.example.restproject.exception.UserAlreadyExistException;
import com.example.restproject.exception.UserNotFoundException;
import com.example.restproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with that name already exist");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("The user was not found");
        }
        return user.get();
    }
}
