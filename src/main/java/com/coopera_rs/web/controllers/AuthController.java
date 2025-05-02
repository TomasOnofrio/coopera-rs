package com.coopera_rs.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopera_rs.application.service.AuthService;
import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;
import com.coopera_rs.web.dto.LoginRequestDTO;
import com.coopera_rs.web.dto.LoginResponseDTO;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;



    public AuthController( AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        User user = UserMapper.toDomain(registerUserDTO);
        User registeredUser = authService.registerUser(user);

        UserResponseDTO responseDTO = UserMapper.toResponseDTO(registeredUser);
        
        return ResponseEntity.ok(responseDTO);           
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        Optional<User> userOptional = authService.findUserByEmail(loginRequestDTO.getEmail());
    
        LoginResponseDTO responseDTO = authService.login(loginRequestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserResponseDTO>> listarUsers() {
        List<User> users = authService.listAllUsers();

        List<UserResponseDTO> responseDTOs = users.stream()
            .map(UserMapper::toResponseDTO)
            .toList();

        return ResponseEntity.ok(responseDTOs);
    }   
}