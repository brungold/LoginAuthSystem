package com.loginauthsystem.security.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {
    public String authenticateAndGenerateToken(String username, String password) {
        return  "token123";
    }
}
