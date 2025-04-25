package com.coopera_rs.application.service;

import java.time.LocalDateTime;
import java.util.*;

import com.coopera_rs.infrastructure.repository.ConfirmationTokenRepository;
import com.coopera_rs.infrastructure.repository.entity.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

import com.coopera_rs.core.User;
import com.coopera_rs.core.port.UserRepository;
import com.coopera_rs.web.dto.LoginRequestDTO;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; 
    private Map<UUID, User> users = new HashMap<>();

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }




    public User registerUser(@Valid User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email atualmente em uso");
        }

        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("Nome de usuário já existe");
        }

        /*
         * var salt = "sdkjfdifji"
         * String cripto = passwordEncoder.encode(user.getPassword()) append 
         */

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getId(), user);
        return userRepository.save(user);
    }

    public boolean verifyLoginUser ( @Valid LoginRequestDTO user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser.isPresent();
    }

    
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<User> listAllUsers(){
        return userRepository.findAll();
    }
}
