package com.taskmaster.taskCreator.controllers;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping
    public String getTasks() {
        return "Hello from backend!";
    }
}
