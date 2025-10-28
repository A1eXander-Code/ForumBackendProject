package com.forum.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.forum.dto.CreateCommentRequest;
import com.forum.forum.dto.DeleteCommentRequest;
import com.forum.forum.service.CommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public void createCommentResponse(@RequestBody CreateCommentRequest createCommentRequest) {
        commentService.createComment(createCommentRequest);
    }

    @DeleteMapping("/delete")
    public void deleteCommentResponse(@RequestBody DeleteCommentRequest deleteCommentRequest) {
        commentService.deleteComment(deleteCommentRequest);
    }
}
