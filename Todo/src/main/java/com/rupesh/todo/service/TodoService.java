package com.rupesh.todo.service;

import com.rupesh.todo.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    //    create
    Todo saveTodo(Todo todo);

    //    get all user
    List<Todo> getAllTodo();

    //    get a single user of given userId
    Todo getTodoId(Long todoId);

//    delete user
    void deleteUserBy(Long todoId);

//    searchUsersByUsername
    List<Todo> searchUsers(String username);
}
