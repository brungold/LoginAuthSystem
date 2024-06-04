package com.loginauthsystem.registration;

import com.loginauthsystem.registration.dto.RegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@Log4j2
public class RegistrationController {
    private RegistrationService registrationService;
    public ResponseEntity<Void> register(@ResponseBody RegisterRequestDto registerRequestDto) {

    }
}
