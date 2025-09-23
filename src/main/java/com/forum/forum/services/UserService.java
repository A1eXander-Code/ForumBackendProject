package com.forum.forum.services;

import java.util.HashMap;
import java.util.Map;

import com.forum.forum.dto.UserLoginRequest;
import com.forum.forum.dto.UserRegisterRequest;
import com.forum.forum.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private Map<String, User> database = new HashMap<>();

    public boolean register(UserRegisterRequest request){
        if(database.containsKey(request.getUsername())){
            return false;
        }
        
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        database.put(newUser.getUsername(), newUser);

        return true;
    }

    public boolean login(UserLoginRequest request){
        if(!database.containsKey(request.getUsername())){
            return false;
        }

        User user = database.get(request.getUsername());
        if(user.getPassword().equals(request.getPassword())){
            return true;
        }

        return false;
    }
}
