package com.forum.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.forum.dto.ApiResponse;
import com.forum.forum.dto.CreatePostRequest;
import com.forum.forum.dto.DeletePostRequest;
import com.forum.forum.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/create")
    public void createPostResponse(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @DeleteMapping("/delete")
    public void DeletePostResponse(@RequestBody DeletePostRequest deletePostRequest) {
        postService.deletePost(deletePostRequest);
    }
}
