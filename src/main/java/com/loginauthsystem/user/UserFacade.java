package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.dto.UserRequestDto;
import com.loginauthsystem.user.entity.UserRole;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;


    public UserDto save(UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

//    public UserDto findById(Long id) {
//        UserDto userDto = userService.findById(id);
//        if (userDto == null) {
//            throw new IllegalStateException("user not found");
//        }
//        return userDto;
//    }

    public UserDto findByEmail(String email) {
        UserDto userDto = userService.findByEmail(email);
        if (userDto == null) {
            throw new IllegalStateException("User not found");
        }
        return  userDto;
    }

    public List<UserDto> findUsersByRoles(UserRole role) {
        List<UserDto> roles = userService.findUsersByRole(role.toString());
        if (roles == null) {
            throw new IllegalStateException("There are no user with this role...");
        }
        return roles;
    }

//    public boolean isUserExists(String email) {
//        return userService.userExists(email);
//    }
}