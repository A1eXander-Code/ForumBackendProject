package com.forum.forum.dto;

import com.forum.forum.entity.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private String username;

    public static RegisterResponse from(User user) {
        return builder().username(user.getUsername()).build();
    }
}
