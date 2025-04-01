package com.coopera_rs.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopera_rs.application.service.UserService;
import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;
import com.coopera_rs.infrastructure.security.jwt.JwtUtil;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final UserService userService;
    private final JwtUtil jwtUtil;


    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        User user = UserMapper.toDomain(registerUserDTO);
        User registeredUser = userService.registerUser(user);

        UserResponseDTO responseDTO = UserMapper.toResponseDTO(registeredUser);
        
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
