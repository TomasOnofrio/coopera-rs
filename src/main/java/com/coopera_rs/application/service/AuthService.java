package com.coopera_rs.application.service;

import java.util.*;

import com.coopera_rs.application.exceptions.AlreadyInUseEmailOrUsername;
import com.coopera_rs.application.exceptions.InvalidEmail;
import com.coopera_rs.application.exceptions.InvalidPassword;
import com.coopera_rs.infrastructure.config.security.jwt.JwtUtil;
import com.coopera_rs.web.dto.LoginResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

import com.coopera_rs.core.User;
import com.coopera_rs.core.port.UserRepository;
import com.coopera_rs.web.dto.LoginRequestDTO;

@Service
@AllArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; 
    private final JwtUtil jwtUtil;






    public User registerUser(@Valid User user){
        List<String> errors = new ArrayList<>();

        Optional<User> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserEmail.isPresent()) {
            errors.add("Email atualmente em uso");
        }

        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            errors.add("Username atualmente em uso");
        }

        if (!errors.isEmpty()) {
            throw new AlreadyInUseEmailOrUsername(errors);
        }

        /*
         * var salt = "sdkjfdifji"
         * String cripto = passwordEncoder.encode(user.getPassword()) append 
         */

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public LoginResponseDTO login(@Valid LoginRequestDTO loginRequestDTO) {
        User existingUser = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(InvalidEmail::new);

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), existingUser.getPassword())) {
            throw new InvalidPassword();
        }

        String token = jwtUtil.generateToken(existingUser.getUsername());

        return new LoginResponseDTO(
                token,
                existingUser.getUsername(),
                existingUser.isEmailVerified());
    }
    
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> listAllUsers(){
        return userRepository.findAll();
    }
}
