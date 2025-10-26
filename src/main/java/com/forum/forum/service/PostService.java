package com.forum.forum.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.forum.forum.entity.User;
import com.forum.forum.dto.CreatePostRequest;
import com.forum.forum.dto.DeletePostRequest;
import com.forum.forum.entity.Post;
import com.forum.forum.repository.PostRepository;
import com.forum.forum.repository.UserRepository;
import com.forum.forum.repository.CommentRepository;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository,
            UserRepository userRepository,
            CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public Optional<Post> createPost(CreatePostRequest request) {
        long userId = request.getUserId();
        String postTitle = request.getPostTitle();
        String postContent = request.getPostContent();
        Optional<User> userOpt = userRepository.findById(userId);
        User user = userOpt.get();
        Post newPost = new Post();
        newPost.setPostTitle(postTitle);
        newPost.setPostContent(postContent);
        newPost.setUser(user);

        return Optional.of(postRepository.save(newPost));
    }

    public void deletePost(DeletePostRequest request) {
        long postId = request.getPostId();
        Optional<Post> postOpt = postRepository.findById(postId);
        Post deletePost = postOpt.get();
        postRepository.delete(deletePost);
    }

    /*
     * public ? searchPostById(long postId) {
     * 
     * 
     * }
     */
}
