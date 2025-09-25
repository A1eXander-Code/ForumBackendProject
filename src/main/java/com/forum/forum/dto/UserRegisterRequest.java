package com.forum.forum.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    String username;
    String password;
    String email;    
}
