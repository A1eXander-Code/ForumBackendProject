package com.forum.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatusCode;
>>>>>>> 259aaeb (Restore project without security config)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.forum.forum.services.UserService;
import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.dto.UserRegisterRequest;
import jakarta.validation.Valid;

import com.forum.forum.dto.UserRegisterRequest;
import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.model.User;
import com.forum.forum.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
<<<<<<< HEAD

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterResponse(@Valid @RequestBody UserRegisterRequest request) {
        boolean result = userService.register(request);
        if(result == true){
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User can't register.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> LoginResponse(@Valid @RequestBody UserLoginRequest request) {
        boolean result = userService.login(request);
        if(result == true){
            return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User can not log in.");
=======
    @Autowired
    UserService userService = new UserService();

    @PostMapping("/register")
    public ResponseEntity<String> RegisterResponse(@RequestBody UserRegisterRequest request) {
        boolean result = userService.register(request);
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).body("User register successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User can't register.");
        }
        
    }

    @PostMapping("/login")
    public ResponseEntity<String> LoginResponse(@RequestBody UserLoginRequest request) {
        boolean result = userService.login(request);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("User login successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User can't login");
>>>>>>> 259aaeb (Restore project without security config)
        }
    }
}
