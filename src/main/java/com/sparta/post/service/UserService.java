package com.sparta.post.service;


import com.sparta.post.dto.LoginUserRequestDto;
import com.sparta.post.dto.LoginUserResponseDto;
import com.sparta.post.dto.SignupUserRequestDto;
import com.sparta.post.dto.SignupUserResponseDto;
import com.sparta.post.entity.User;
import com.sparta.post.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입 기능
    public SignupUserResponseDto signup(SignupUserRequestDto signupUserRequestDto) {
        String username = signupUserRequestDto.getUsername();
        String password = passwordEncoder.encode(signupUserRequestDto.getPassword());

        //회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        //사용자 등록 =>입력한 이름과 암호화된 비밀번호 저장
        User user = new User(username,password);
        userRepository.save(user);

        SignupUserResponseDto res = new SignupUserResponseDto("회원가입 성공",200);

        return res;
    }


    //로그인 기능 -> security 분리 이전
    public LoginUserResponseDto login(LoginUserRequestDto loginUserRequestDto) {
        String username = loginUserRequestDto.getUsername();
        String password = loginUserRequestDto.getPassword();

        //사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        //비밀번호 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        //JWT 생성 및 쿠키에 저장 후 res


    }


    //회원가입

}
