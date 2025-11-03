package com.forum.forum.service;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.forum.forum.dto.CreateCommentRequest;
import com.forum.forum.dto.DeleteCommentRequest;
import com.forum.forum.repository.CommentRepository;
import com.forum.forum.repository.PostRepository;
import com.forum.forum.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import com.forum.forum.entity.*;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(
            CommentRepository commentRepository,
            UserRepository userRepository,
            PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Optional<Comment> createComment(CreateCommentRequest request) {
        long userId = request.getUserId();
        long postId = request.getPostId();
        String commentContent = request.getCommentContent();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User " + userId + " not found"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post " + postId + " not found"));
        Comment newComment = Comment.builder()
            .commentContent(commentContent)
            .user(user)
            .post(post)
            .build();

        return Optional.of(commentRepository.save(newComment));
    }

    public void deleteComment(DeleteCommentRequest request) {
        long commentId = request.getCommentId();
        try {
            commentRepository.deleteById(commentId);
        } catch (EmptyResultDataAccessException ignore) {

        }
    }
}
