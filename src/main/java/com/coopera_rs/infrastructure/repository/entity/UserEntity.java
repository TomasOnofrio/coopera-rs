package com.coopera_rs.infrastructure.repository.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Column
    private String password;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column
    private boolean emailVerified;


    public UserEntity() {
    }

    public UserEntity(UUID id,String username, String password, String email,  boolean emailVerified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailVerified = emailVerified;
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

}
