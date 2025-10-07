package com.forum.forum.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private long userId;
    private String postTitle;
    private String postContent;
}
