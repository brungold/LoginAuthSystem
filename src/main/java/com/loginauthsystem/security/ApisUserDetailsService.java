package com.loginauthsystem.security;

import com.loginauthsystem.user.UserFacade;
import com.loginauthsystem.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
class ApisUserDetailsService implements UserDetailsService {
    private final UserFacade userFacade;
    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserDto userDTO = userFacade.findByEmail(username);
        return getUser(userDTO);
    }

    private org.springframework.security.core.userdetails.User getUser(UserDto userDto) {
        List<String> authorities = userDto.userRoles()
                .stream()
                .map(Enum::toString)
                .toList();
        List<SimpleGrantedAuthority> simpleAuthorities = authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        log.info("LoginUserDetailsService: Logged new user. User " + userDto.email() + " has authorities " + simpleAuthorities);
        return new org.springframework.security.core.userdetails.User(
                userDto.email(),
                userDto.password(),
                simpleAuthorities);
    }
}
