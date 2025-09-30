package com.forum.forum.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;
}
