package com.loginauthsystem.user;

import com.loginauthsystem.user.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findUsersByRoles(String role);

    User save(User user);

    boolean existsByEmail(String email);

}
