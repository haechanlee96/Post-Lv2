package com.sparta.post.controller;

import com.sparta.post.dto.AuthRequestDto;
import com.sparta.post.dto.MessageResponseDto;
import com.sparta.post.jwt.JwtUtil;
import com.sparta.post.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public MessageResponseDto login(HttpServletResponse response, @RequestBody AuthRequestDto requestDto) {
        String token = authService.getToken(requestDto);
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);
        return new MessageResponseDto("로그인 성공", 200);
    }

    @PostMapping("/signup")
    public MessageResponseDto signup(@RequestBody @Valid AuthRequestDto requestDto) {
        authService.saveUser(requestDto);
        return new MessageResponseDto("회원가입 성공", 200);
    }
}
