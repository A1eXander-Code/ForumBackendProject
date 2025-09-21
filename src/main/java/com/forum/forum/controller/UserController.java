package com.forum.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.forum.forum.services.UserService;
import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.dto.UserRegisterRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterResponse(@RequestBody UserRegisterRequest request) {
        boolean result = userService.registerFunc(request);
        if(result == true){
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User can't register.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> LoginResponse(@RequestBody UserLoginRequest request) {
        boolean result = userService.loginFunc(request);
        if(result == true){
            return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User can not log in.");
        }
    }
}

