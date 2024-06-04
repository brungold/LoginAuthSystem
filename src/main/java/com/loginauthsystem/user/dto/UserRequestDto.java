package com.loginauthsystem.user.dto;

import com.loginauthsystem.user.entity.UserRole;
import lombok.Builder;

import java.util.Set;
@Builder
public record UserRequestDto(

        String email,
        String password,
        Set<UserRole> userRoles

) {
}
