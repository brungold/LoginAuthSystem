package com.loginauthsystem.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    public final UserRepository userRepository;
}
