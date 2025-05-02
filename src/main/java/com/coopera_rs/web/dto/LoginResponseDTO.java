package com.coopera_rs.web.dto;

public class LoginResponseDTO {
    private String token;
    private String username;
    //private ROLE role;
    private boolean isEmailVerified;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String token,String username, boolean isEmailVerified) {
        this.token = token;
        this.username = username;
        this.isEmailVerified = isEmailVerified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

}