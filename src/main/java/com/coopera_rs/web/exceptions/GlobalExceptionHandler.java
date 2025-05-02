package com.coopera_rs.web.exceptions;

import com.coopera_rs.application.exceptions.AlreadyInUseEmailOrUsername;
import com.coopera_rs.application.exceptions.InvalidEmail;
import com.coopera_rs.application.exceptions.InvalidPassword;
import com.coopera_rs.web.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> genericException(Exception ex) {
        ErrorResponseDTO error = ErrorResponseDTO
                .builder()
                .statusMessage(HttpStatus.NO_CONTENT.name())
                .success(false)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .error(List.of(ex.getMessage()))
                .build();

        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler({
            InvalidEmail.class,
            InvalidPassword.class})
    public ResponseEntity<ErrorResponseDTO> InvalidCredentials(RuntimeException ex) {
        ErrorResponseDTO error = ErrorResponseDTO
                .builder()
                .statusMessage(HttpStatus.UNAUTHORIZED.name())
                .success(false)
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .error(List.of(ex.getMessage()))
                .build();

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AlreadyInUseEmailOrUsername.class)
    public ResponseEntity<ErrorResponseDTO> AlreadyInUse(AlreadyInUseEmailOrUsername ex) {
        ErrorResponseDTO error = ErrorResponseDTO
                .builder()
                .statusMessage(HttpStatus.I_AM_A_TEAPOT.name())
                .success(false)
                .statusCode(HttpStatus.I_AM_A_TEAPOT.value())
                .error(ex.getErrors())
                .build();

        return new ResponseEntity<>(error, HttpStatus.I_AM_A_TEAPOT);
    }
}
