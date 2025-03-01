package com.taskmaster.taskCreator.repository;

import com.taskmaster.taskCreator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);  // Поиск пользователя по email
}
