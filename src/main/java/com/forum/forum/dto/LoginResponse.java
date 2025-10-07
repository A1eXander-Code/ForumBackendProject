package com.forum.forum.dto;

import com.forum.forum.entity.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String username;

    public static LoginResponse from(User user) {
        return builder().username(user.getUsername()).build();
    }
}
