package com.rupesh.todo.controller;

import com.rupesh.todo.entities.Todo;
import com.rupesh.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

//    creat
    @PostMapping
    public ResponseEntity<Todo> createUser(@RequestBody Todo todo){
        Todo todo1 = todoService.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo1);
    }

//    get all user
    @GetMapping
    public ResponseEntity<List<Todo>> getAllUser(){
        List<Todo> getalluser = todoService.getAllTodo();
        return ResponseEntity.ok(getalluser);
    }

//    get by id

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getsinglevalue(@PathVariable Long todoId){
        Todo todo = todoService.getTodoId(todoId);
        return ResponseEntity.ok(todo);
    }

//    delete user by id
@DeleteMapping("/{todoId}")
public ResponseEntity<Void> deleteByUserId(@PathVariable Long todoId) {
    todoService.deleteUserBy(todoId);
    return ResponseEntity.noContent().build();

    }
    @GetMapping("/search/{query}")
    public ResponseEntity<List<Todo>> searchUser(@PathVariable String query){
        return ResponseEntity.ok(todoService.searchUsers(query));
    }

}
