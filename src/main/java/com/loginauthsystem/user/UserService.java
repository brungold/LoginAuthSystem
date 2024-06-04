package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.dto.UserRequestDto;
import com.loginauthsystem.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService  {
    private final UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    public UserDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(UserMapper::fromUserToUserDto)
                .orElse(null);
    }
    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return  user.map(UserMapper::fromUserToUserDto)
                .orElse(null); // write exception ?
    }
    public UserDto save(UserRequestDto userRequestDto) {
        User user = UserMapper.fromUserRequestDtoToUser(userRequestDto);
        User userSaved = userRepository.save(user);
        return UserMapper.fromUserToUserDto(userSaved);
    }

}
