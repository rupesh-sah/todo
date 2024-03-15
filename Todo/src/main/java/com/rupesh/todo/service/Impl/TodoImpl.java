package com.rupesh.todo.service.Impl;

import com.rupesh.todo.entities.Todo;
import com.rupesh.todo.repo.TodoRepo;
import com.rupesh.todo.service.TodoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoImpl implements TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepo.findAll();
    }

    @Override
    public Todo getTodoId(Long todoId) {
        return todoRepo.findById(todoId).orElseThrow(()-> new  RuntimeException("User not found"));
    }

    @Override
    public void deleteUserBy(Long todoId) {
        todoRepo.deleteById(todoId);
    }

    @Override
    public List<Todo> searchUsers(String username) {
        List<Todo> todos = todoRepo.searchProducts(username);

        return todos;
    }

}
