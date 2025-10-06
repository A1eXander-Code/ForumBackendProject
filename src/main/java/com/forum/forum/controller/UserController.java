package com.forum.forum.controller;

import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.forum.forum.service.UserService;
import com.forum.forum.dto.*;
import com.forum.forum.dto.resultcode.AuthCode;
import com.forum.forum.dto.resultcode.RegistrationCode;
import com.forum.forum.dto.resultcode.ResultCode;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> RegisterResponse(@RequestBody UserRegisterRequest request) {
        return userService.register(request)
            .map(user -> accountCreated(
                RegistrationCode.REGISTER_SUCCESS,
                "User account registered successfully",
                RegisterResponse.from(user)))
            .orElseGet(() -> registerConflict(
                RegistrationCode.USERNAME_EXISTS, 
                "Username exists"));
        
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> LoginResponse(@RequestBody UserLoginRequest request) {
        return userService.login(request)
            .map(user -> accountLogin(
                AuthCode.LOGIN_SUCCESS, 
                "User logged in successfully", 
                LoginResponse.from(user)))
            .orElseGet(() -> loginConflict(
                AuthCode.INVALID_CREDENTIALS, 
                "Incorrect username or password"));
    }

    private ResponseEntity<ApiResponse<RegisterResponse>> accountCreated(ResultCode code, String message, RegisterResponse data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(code, message, data));
    }

    private ResponseEntity<ApiResponse<RegisterResponse>> registerConflict(ResultCode code, String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(code, message));
    }

    private ResponseEntity<ApiResponse<LoginResponse>> accountLogin(ResultCode code, String message, LoginResponse data){
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(code, message, data));
    }
    
    private ResponseEntity<ApiResponse<LoginResponse>> loginConflict(ResultCode code, String message){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error(code, message));
    }
}
