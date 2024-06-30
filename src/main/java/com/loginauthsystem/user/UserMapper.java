package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.dto.UserRequestDto;
import com.loginauthsystem.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
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
    public static User fromUserRequestDtoToUser (UserRequestDto userRequestDto) {
        return User.builder()
                .email(userRequestDto.email())
                .password(userRequestDto.password())
                .userRoles(userRequestDto.userRoles())
                .build();
    }
}
