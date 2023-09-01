package com.sparta.post.dto;

import lombok.Getter;

@Getter
public class SignupUserRequestDto {
    private String username;
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
