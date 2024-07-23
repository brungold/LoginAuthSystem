package com.loginauthsystem.user;

import com.loginauthsystem.user.entity.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByConfirmationToken(String confirmationToken);
    User save(User user);

    boolean existsByEmail(String email);

}
