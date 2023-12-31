package com.sparta.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Spring Security 인증 기능 제외
@EnableJpaAuditing
@SpringBootApplication
public class PostLv2Application {

    public static void main(String[] args) {
        SpringApplication.run(PostLv2Application.class, args);
    }

}
