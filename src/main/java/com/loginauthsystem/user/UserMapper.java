package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .userRoles(user.getUserRoles())
                .locked(user.getLocked())
                .enabled(user.getEnabled())
                .build();
    }
}
