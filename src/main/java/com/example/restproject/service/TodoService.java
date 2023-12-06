package com.example.restproject.service;

import com.example.restproject.entity.TodoEntity;
import com.example.restproject.entity.UserEntity;
import com.example.restproject.model.Todo;
import com.example.restproject.repository.TodoRepo;
import com.example.restproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.tomModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.tomModel(todoRepo.save(todo));
    }
}
