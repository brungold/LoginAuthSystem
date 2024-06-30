package com.loginauthsystem;

import com.loginauthsystem.security.jwt.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {JwtConfigurationProperties.class})
public class LoginAuthSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginAuthSystemApplication.class, args);
    }
}