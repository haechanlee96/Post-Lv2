package com.sparta.post.dto;

import lombok.Getter;

@Getter
public class StatusResponseDto {
    private Long id;
    private String msg;
    private Integer statusCode;

    public StatusResponseDto(String msg, Integer statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
