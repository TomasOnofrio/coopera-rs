package com.coopera_rs.web.dto;

public class LoginResponseDTO {
    private String token;
    private boolean isEmailVerified;

    public LoginResponseDTO(String token, boolean isEmailVerified) {
        this.token = token;
        this.isEmailVerified = isEmailVerified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }
}