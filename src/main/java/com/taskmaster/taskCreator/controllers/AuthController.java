package com.taskmaster.taskCreator.controllers;

import com.taskmaster.taskCreator.dto.LoginRequest;
import com.taskmaster.taskCreator.dto.LoginResponse;
import com.taskmaster.taskCreator.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/auth")  // Все запросы будут начинаться с /api/auth
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")  // POST запрос для логина
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());  // Вызываем метод из сервиса
            return ResponseEntity.ok(new LoginResponse(token));  // Возвращаем токен пользователю
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Ошибка авторизации");  // Ошибка, если данные неверны
        }
    }
}
