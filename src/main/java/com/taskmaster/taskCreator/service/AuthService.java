package com.taskmaster.taskCreator.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.taskmaster.taskCreator.model.User;
import com.taskmaster.taskCreator.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return generateToken(user);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256("your-secret-key");
        return JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(algorithm);
    }
}
