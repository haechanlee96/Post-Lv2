package com.sparta.post.controller;

import com.sparta.post.dto.LoginUserRequestDto;
import com.sparta.post.dto.LoginUserResponseDto;
import com.sparta.post.dto.SignupUserRequestDto;
import com.sparta.post.dto.SignupUserResponseDto;
import com.sparta.post.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //회원가입 구현
    @PutMapping("/auth/signup")
    public SignupUserResponseDto signup(SignupUserRequestDto signupUserRequestDto) {
        return userService.signup(signupUserRequestDto);
    }

    //로그인 구현
    @PutMapping("/auth/login")
    public LoginUserResponseDto login(LoginUserRequestDto loginUserRequestDto){
        return userService.login(loginUserRequestDto);
    }

}
