package com.loginauthsystem.user;

import com.loginauthsystem.user.dto.UserDto;
import com.loginauthsystem.user.dto.UserRequestDto;
import com.loginauthsystem.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
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
        return user.map(UserMapper::fromUserToUserDto)
                .orElse(null); // write exception ?
    }

    public UserDto save(UserRequestDto userRequestDto) {
        User user = UserMapper.fromUserRequestDtoToUser(userRequestDto);
        User userSaved = userRepository.save(user);
        return UserMapper.fromUserToUserDto(userSaved);
    }

    public boolean userExists(User user) {
        return userRepository.findByEmail(user.getEmail())
                .isPresent();
    }
    public List<UserDto> findUsersByRole(String role) {
        List<User> users = userRepository.findUsersByRoles(role);
        return users.stream()
                .map(UserMapper::fromUserToUserDto)
                .toList();
    }

}
