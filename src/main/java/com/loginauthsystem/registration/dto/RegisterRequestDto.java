package com.loginauthsystem.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Set;


@AllArgsConstructor
@Data
public class RegisterRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;

}
