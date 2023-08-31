package com.sparta.post.service;

import com.sparta.post.dto.AuthRequestDto;
import com.sparta.post.entity.User;
import com.sparta.post.jwt.JwtUtil;
import com.sparta.post.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String getToken(AuthRequestDto requestDto) {
        // username 존재 확인.
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원은 존재하지 않습니다."));

        // 비밀 번호 확인.
        if(!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        // token 생성.
        return jwtUtil.createToken(user.getUsername());
    }

    @Transactional
    public void saveUser(AuthRequestDto requestDto) {
        userRepository.findByUsername(requestDto.getUsername())
                .ifPresent(user -> {
                    throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
                });

        User user = new User(requestDto, passwordEncoder);
        userRepository.save(user);
    }
}
