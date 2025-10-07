package com.forum.forum.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entity.Comment;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    boolean existsByCommentId(long commentId);

    Optional<Comment> findByCommentId(long commentId);
}
