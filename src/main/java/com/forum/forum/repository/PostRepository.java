package com.forum.forum.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entity.Post;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByPostId(long postId);

    Optional<Post> findByPostId(long postId);

    boolean existsByPostTitle(String postTitle);

    Optional<Post> findByPostTitle(String postTitle);
}
