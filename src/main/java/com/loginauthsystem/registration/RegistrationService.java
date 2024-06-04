package com.loginauthsystem.registration;

import com.loginauthsystem.registration.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RegistrationService {
    public void register(RegisterRequestDto registerRequestDto) {
       log.info("A new user try register account...");

       registerRequestDto.
    }
}
