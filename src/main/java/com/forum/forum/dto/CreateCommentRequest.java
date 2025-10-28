package com.forum.forum.dto;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private long userId;
    private long postId;
    private String commentContent;
}
