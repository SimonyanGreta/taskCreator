package com.taskmaster.taskCreator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String email;  // Уникальный идентификатор пользователя, email

    @Column(nullable = false)
    private String password;  // Пароль пользователя

    // Конструкторы, геттеры и сеттеры
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
