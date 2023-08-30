package com.sparta.post.controller;

import com.sparta.post.dto.*;
import com.sparta.post.entity.User;
import com.sparta.post.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //회원가입 구현
    @PostMapping("/auth/signup")
    public StatusResponseDto signup(SignupUserRequestDto signupUserRequestDto) {
        return userService.signup(signupUserRequestDto);
    }


    //로그인 구현
    @PostMapping("/auth/login")
    public StatusResponseDto login(LoginUserRequestDto loginUserRequestDto, HttpServletResponse res){
        return userService.login(loginUserRequestDto, res);
    }

}
