package com.coopera_rs.web.dto;

import java.util.UUID;

public class UserResponseDTO {

    private UUID id;
    private String username;
    private String email;
    private boolean emailVerified;

    public UserResponseDTO(UUID id, String username, String email, boolean emailVerified) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.emailVerified = emailVerified;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }
}