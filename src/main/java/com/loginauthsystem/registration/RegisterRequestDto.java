package com.loginauthsystem.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Set;


record RegisterRequestDto(
        String username,
        String password) {
}
