package com.forum.forum.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long commentId;

    @Column(name = "conmment_content", nullable = false, length = 255)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    private static Comment build(String commentContent, User user, Post post) {
        if (commentContent == null || commentContent.isBlank())
            throw new IllegalArgumentException("Comment needed");
        Comment c = new Comment();
        c.commentContent = commentContent;
        c.user = user;
        c.post = post;
        return c;
    }
}
