package com.sparta.post.entity;


import com.sparta.post.dto.SignupUserRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false,unique = true)
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "아이디는 소문자 및 숫자로 구성된 4~10자의 문자열이어야 합니다.")
    private String username;

    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,15}$", message = "비밀번호는 대소문자 및 숫자로 구성된 8~15자의 문자열이어야 합니다.")
    private String password;

    public User(SignupUserRequestDto signupUserRequestDto) {
        this.username = signupUserRequestDto.getUsername();
        this.password = signupUserRequestDto.getPassword();
    }
}
