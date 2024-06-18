package com.loginauthsystem.user.entity;

import com.loginauthsystem.security.util.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private boolean enabled = true;

    private Collection<String> authorities = new HashSet<>();

    public User(String email, String password, boolean enabled, Collection<String> userRoles) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = userRoles;
    }
}

