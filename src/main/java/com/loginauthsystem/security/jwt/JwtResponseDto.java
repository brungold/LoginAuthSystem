package com.loginauthsystem.security.jwt;

import lombok.Builder;

@Builder
public record JwtResponseDto(String token) {
}
