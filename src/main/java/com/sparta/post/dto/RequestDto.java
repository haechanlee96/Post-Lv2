package com.sparta.post.dto;

import lombok.Getter;

@Getter
public class RequestDto {
    private String title;
    private String contents;
    private String username;
    private int password;
}
