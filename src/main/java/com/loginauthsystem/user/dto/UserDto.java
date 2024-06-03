package com.loginauthsystem.user.dto;

import com.loginauthsystem.user.entity.UserRole;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        Set<UserRole> userRoles,
        Boolean locked,
        Boolean enabled
) {
}
