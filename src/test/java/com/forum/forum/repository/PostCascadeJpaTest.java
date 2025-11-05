package com.forum.forum.repository;

import com.forum.forum.entity.Comment;
import com.forum.forum.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostCascadeJpaTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    EntityManager em;

    @Test
    void deletingPost_cascadesToComments() {
        Post post = new Post();
        post.setPostTitle("Post Title");
        post.setPostContent("Post Content");

        Comment comment1 = new Comment();
        comment1.setCommentContent("Comment 1");
        Comment comment2 = new Comment();
        comment2.setCommentContent("Comment 2");

        post.setComments(new java.util.ArrayList<>(java.util.List.of(comment1, comment2)));
        comment1.setPost(post);
        comment2.setPost(post);

        post = postRepository.save(post);
        em.flush(); em.clear();

        long postId = post.getPostId();
        long beforeCount = commentRepository.countByPostId(postId);
        assertThat(beforeCount).isEqualTo(2);
        
        postRepository.deleteById(postId);
        em.flush(); em.clear();

        assertThat(postRepository.findById(postId)).isEmpty();
        assertThat(commentRepository.countByPostId(postId)).isZero();
    }
}
