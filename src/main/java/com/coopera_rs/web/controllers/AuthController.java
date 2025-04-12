package com.coopera_rs.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopera_rs.application.service.UserService;
import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;
import com.coopera_rs.infrastructure.security.jwt.JwtUtil;
import com.coopera_rs.web.dto.LoginRequestDTO;
import com.coopera_rs.web.dto.LoginResponseDTO;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;
import com.coopera_rs.web.dto.LoginResponseDTO.ErrorResponseDTO;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        User user = UserMapper.toDomain(registerUserDTO);
        User registeredUser = userService.registerUser(user);

        UserResponseDTO responseDTO = UserMapper.toResponseDTO(registeredUser);
        System.out.println("Senha codificada: " + user.getPassword());
        
        System.out.println("Senha armazenada: " + user.getPassword());

        
        return ResponseEntity.ok(responseDTO);           
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        Optional<User> userOptional = userService.findUserByUsername(loginRequestDTO.getUsername());
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponseDTO(false, "Credenciais inválidas"));
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponseDTO(false, "Credenciais inválidas"));
        }

        String token = jwtUtil.generateToken(user.getUsername());

        boolean isEmailVerified = user.isEmailVerified();
    
        LoginResponseDTO responseDTO = new LoginResponseDTO(token, isEmailVerified);
    
        System.out.println("Senha válida: " + passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword()));
        System.out.println("Senha fornecida: " + loginRequestDTO.getPassword());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserResponseDTO>> listarUsers() {
        List<User> users = userService.listAllUsers();

        List<UserResponseDTO> responseDTOs = users.stream()
            .map(UserMapper::toResponseDTO)
            .toList();

        return ResponseEntity.ok(responseDTOs);
    }   
}