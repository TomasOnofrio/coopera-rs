package com.coopera_rs.web.dto;

public class LoginResponseDTO {
    private String token;
    private boolean isEmailVerified;

    public LoginResponseDTO() {}

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

    public static class ErrorResponseDTO {
        private boolean success;
        private String message;

        public ErrorResponseDTO() {}

        public ErrorResponseDTO(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}