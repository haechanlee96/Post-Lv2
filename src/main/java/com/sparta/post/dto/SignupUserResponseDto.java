package com.sparta.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class SignupUserResponseDto {
    private Long id;
    private String msg;
    private Integer statusCode;

    public SignupUserResponseDto(String msg, Integer statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

}
