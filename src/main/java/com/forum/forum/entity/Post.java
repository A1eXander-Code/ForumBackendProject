package com.forum.forum.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long postId;

    @Column(name = "post_title", nullable = false, length = 20)
    private String postTitle;

    @Column(name = "post_content", nullable = false, length = 255)
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Builder
    private static Post build(String postTitle, String postContent, User user) {
        if (postTitle == null || postTitle.isBlank())
            throw new IllegalArgumentException("Post title needed");
        if (postContent == null || postContent.isBlank())
            throw new IllegalArgumentException("Post content needed");
        Post p = new Post();
        p.postTitle = postTitle;
        p.postContent = postContent;
        p.user = user;
        return p;
    }

}
