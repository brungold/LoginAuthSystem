package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.dto.UserRequestDto;
import com.loginauthsystem.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;



    public UserDto save(UserRequestDto userRequestDto) {

    }

    public UserDto findById(Long id) {
        UserDto userDto = userService.findById(id);
        if (userDto == null) {
            throw new IllegalStateException("user not found");
        }
        return userDto;
    }

    public String registerANewUser(User user) {
        if (userExists(user)) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        //TODO
        //ConfirmationToken confirmationToken = new ConfirmationToken();
    }

    private boolean userExists(User user) {
        return userRepository.findByEmail(user.getEmail())
                .isPresent();
    }
}