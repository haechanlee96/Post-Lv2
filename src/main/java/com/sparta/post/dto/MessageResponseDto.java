package com.sparta.post.dto;

import lombok.Getter;

@Getter
public class MessageResponseDto {
    private String msg;
    private int statusCode;

    public MessageResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
