package com.coopera_rs.web.dto;

import com.coopera_rs.core.validation.PasswordValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestDTO {

    @NotBlank
    private String token;

    @NotBlank
    @PasswordValidator
    private String newPassword;

    @NotBlank
    private String confirmPassword;
}