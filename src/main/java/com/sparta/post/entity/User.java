package com.sparta.post.entity;

import com.sparta.post.dto.AuthRequestDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity @Table(name = "users")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public User(AuthRequestDto requestDto, PasswordEncoder passwordEncoder) {
        this.username = requestDto.getUsername();
        this.password = passwordEncoder.encode(requestDto.getPassword());
    }
}
