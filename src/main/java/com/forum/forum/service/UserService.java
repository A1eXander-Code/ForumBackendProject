package com.forum.forum.service;

import java.lang.foreign.Linker.Option;
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

        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if(!userOpt.isEmpty()){
            User user = userOpt.get();
            if(user.getPassword().equals(request.getPassword())){
                return userOpt;
            }else{
                return Optional.empty();
            }
        }else{
            return Optional.empty();
        }
    }
}