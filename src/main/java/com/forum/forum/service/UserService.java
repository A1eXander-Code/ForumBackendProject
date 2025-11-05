package com.forum.forum.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.forum.forum.controller.UserController;
import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.dto.UserRegisterRequest;
import com.forum.forum.entity.User;
import com.forum.forum.repository.UserRepository;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> register(UserRegisterRequest request) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()
                || userRepository.existsByUsername(request.getUsername())) {
            return Optional.empty();
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        userRepository.save(newUser);

        return Optional.of(newUser);
    }

    public Optional<User> login(UserLoginRequest request) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()
                || !userRepository.existsByUsername(request.getUsername())) {
            return Optional.empty();
        }

        return userRepository.findByUsername(request.getUsername())
            .filter(u -> Objects.equals(u.getPassword(), request.getPassword()));
    }
}