package com.ccms.service;

import com.ccms.model.User;
import com.ccms.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User register(User user) {
        if (userRepo.findFirstByEmailOrderByIdAsc(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }
        return userRepo.save(user);
    }

    public Optional<User> login(String email, String password) {
        return userRepo.findFirstByEmailOrderByIdAsc(email)
                .filter(u -> u.getPassword().equals(password));
    }
}
