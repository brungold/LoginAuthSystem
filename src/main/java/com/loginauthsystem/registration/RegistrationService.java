package com.loginauthsystem.registration;

import com.loginauthsystem.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RegistrationService {
    private final UserFacade userFacade;
    public void register(RegisterRequestDto registerRequestDto) {
       log.info("The client is trying to create a new user");


    }
}
