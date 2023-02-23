package com.example.todolistserver.controller;

import com.example.todolistserver.model.TodoResponse;
import com.example.todolistserver.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create() {
        System.out.println("CREATE");
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(){
        System.out.println("READ ONE");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("READ ALL");
        return null;
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update() {
        System.out.println("UPDATE");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne() {
        System.out.println("DELETE");
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        return null;
    }
}
