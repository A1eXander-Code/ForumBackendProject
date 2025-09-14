package com.forum.forum.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @PostMapping("/register")
    public String RegisterResponse() {
        return "User registered successfully.";
    }
    @PostMapping("/login")
    public String LoginResponse() {
        return "User logged in successfully.";
    }
}

