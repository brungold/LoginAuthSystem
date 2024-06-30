package com.loginauthsystem.registration;


import org.springframework.security.core.userdetails.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Log4j2
public class RegistrationController {
    private UserDetailsManager userDetailsManager;
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> register(@RequestBody RegisterRequestDto dto) {
        log.info("New user registration request");
        String password = dto.password();
        String username = dto.username();
        UserDetails user = User.builder()
                .username(username)
                .password(password)
                .build();
        userDetailsManager.createUser(user);
        return ResponseEntity.ok(new RegisterUserResponseDto("Created user"));
    }
}
