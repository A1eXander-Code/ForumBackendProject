package com.forum.forum.service;

import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.entity.User;
import com.forum.forum.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void login_success_return_OptionalUser() {
        when(userRepository.findByUsername("Bob"))
            .thenReturn(Optional.of(new User("Bob", "passwordBob")));
        
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("Bob");
        userLoginRequest.setPassword("passwordBob");

        var result = userService.login(userLoginRequest);

        assertTrue(result.isPresent());
        assertEquals("Bob", result.get().getUsername());
        verify(userRepository).findByUsername("Bob");
    }
}
