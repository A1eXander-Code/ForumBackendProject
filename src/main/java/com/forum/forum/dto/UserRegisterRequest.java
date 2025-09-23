package com.forum.forum.dto;

import lombok.Data;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserRegisterRequest {
    @NotBlank(message="Username is required.")
    @Size(min = 3, max = 20, message = "Username must be 3~20 characters.")
    private String username;

    @NotBlank(message="Password is required.")
    @Size(min = 5, max = 20, message = "Password must be 5~20 characters.")
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @NotBlank(message="Email is required.")
    @Size(min = 5, max = 50, message = "Email must be 5~50 characters.")
    private String email;
}
