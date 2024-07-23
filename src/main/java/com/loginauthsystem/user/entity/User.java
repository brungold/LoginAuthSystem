package com.loginauthsystem.user.entity;

import com.loginauthsystem.security.util.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Collection;
import java.util.HashSet;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String confirmationToken;

    private boolean enabled = false;

    private Collection<String> authorities = new HashSet<>();

    public boolean confirm(){
        this.setEnabled(true);
        this.setConfirmationToken(null);
        return true;
    }

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Collection<String> getAuthorities() {
        return authorities;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User(String email, String password, String confirmationToken, Collection<String> authorities) {
        this.email = email;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.authorities = authorities;
    }
}

