package com.loginauthsystem.user;

import com.loginauthsystem.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public String registerANewUser(User user) {
        if (userExists(user)) {
            throw new IllegalStateException("email already taken");
        }
    }

    private boolean userExists(User user) {
        return userRepository.findByEmail(user.getEmail())
                .isPresent();
    }
}