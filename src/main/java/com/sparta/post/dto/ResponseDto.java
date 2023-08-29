package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private int password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.username = post.getUsername();
//        this.password = post.getPassword();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
