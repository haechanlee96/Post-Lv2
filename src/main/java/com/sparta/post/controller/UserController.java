package com.sparta.post.controller;

import com.sparta.post.dto.*;
import com.sparta.post.entity.User;
import com.sparta.post.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
    public StatusResponseDto signup(@RequestBody @Valid SignupUserRequestDto signupUserRequestDto) {
        return userService.signup(signupUserRequestDto);
    }


    //로그인 구현
    //spring security -> 적용 시 , jwt필터에서 처리하기 때문에 필요없어짐

//    @PostMapping("/auth/login")
//    public StatusResponseDto login(@RequestBody LoginUserRequestDto loginUserRequestDto, HttpServletResponse res){
//        return userService.login(loginUserRequestDto, res);
//    }

}
