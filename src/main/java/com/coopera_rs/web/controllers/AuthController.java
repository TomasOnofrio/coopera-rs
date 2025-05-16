package com.coopera_rs.web.controllers;

import com.coopera_rs.application.service.EmailService;
import com.coopera_rs.web.dto.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopera_rs.application.service.AuthService;
import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;

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
    private final EmailService emailService;


    public AuthController(AuthService authService, EmailService emailService) {
        this.authService = authService;
        this.emailService = emailService;
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

    @PostMapping("/linkPasswordChange")
    public ResponseEntity<String> emailTrocaSenha(@RequestBody EmailDTO emailDTO) {
        String email = emailDTO.getEmail();
        String url = emailDTO.getUrl();
        System.out.println("-----------------");
        System.out.println(url);
        Optional<User> userOptional = authService.findUserByEmail(email);
        boolean userEmpty = userOptional.isEmpty();
        if(!userEmpty) {
            User user = userOptional.get();
            if(emailService.sendPasswordLink(user,url)){
                return ResponseEntity.ok("Email enviado com sucesso!");
            }
        }
        return ResponseEntity.badRequest().body("Erro ao enviar email!");
    }
}