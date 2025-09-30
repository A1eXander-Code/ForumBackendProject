package com.forum.forum.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.forum.forum.controller.UserController;
import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.dto.UserRegisterRequest;
import com.forum.forum.entity.User;
import com.forum.forum.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegisterRequest request) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()
                || userRepository.existsByUsername(request.getUsername())) {
            return false;
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        userRepository.save(newUser);

        return true;
    }

    public boolean login(UserLoginRequest request) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()
                || !userRepository.existsByUsername(request.getUsername())) {
            return false;
        }

        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isEmpty())
            return false;
        User user = userOpt.get();

        return user.getPassword().equals(request.getPassword());
    }
}