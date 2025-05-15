package com.coopera_rs.application.service;

import java.util.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

import com.coopera_rs.core.domain.User;
import com.coopera_rs.core.port.UserRepository;
import com.coopera_rs.web.dto.LoginRequestDTO;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; 
    private Map<Long, User> users = new HashMap<>();

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }




    public User registerUser(@Valid User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email atualmente em uso");
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
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        return existingUser.isPresent();
    }


    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> listAllUsers(){
        return userRepository.findAll();
    }
}
