package com.coopera_rs.core.validation;

import com.coopera_rs.core.validation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.length() < 6) {
            return false; 
        }

        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowerCase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialChar = password.chars().anyMatch(ch -> "!@#$%^&*()_+[]{}|;:,.<>?".indexOf(ch) >= 0);

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
}
