package com.coopera_rs.infrastructure.config.security;

import com.coopera_rs.web.dto.ErrorResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusMessage("Unauthorized")
                .success(false)
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .error(Collections.singletonList("Token de autenticação inválido ou ausente."))
                .build();

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), errorResponseDTO);
    }
}
