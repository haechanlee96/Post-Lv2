package com.sparta.post.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignupUserRequestDto {
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "아이디는 소문자 및 숫자로 구성된 4~10자의 문자열이어야 합니다.")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,15}$", message = "비밀번호는 대소문자 및 숫자로 구성된 8~15자의 문자열이어야 합니다.")
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
