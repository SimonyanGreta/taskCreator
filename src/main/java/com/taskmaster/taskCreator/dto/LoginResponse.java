package com.taskmaster.taskCreator.dto;

public class LoginResponse {

    private String token;

    // Конструкторы
    public LoginResponse() {}

    public LoginResponse(String token) {
        this.token = token;
    }

    // Геттеры и сеттеры
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
