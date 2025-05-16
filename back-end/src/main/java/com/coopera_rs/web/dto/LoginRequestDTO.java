package com.coopera_rs.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @Email
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}