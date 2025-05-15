package com.coopera_rs.core.port;

import java.util.List;
import java.util.Optional;

import com.coopera_rs.core.User;

public interface UserRepository {
    
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    List<User> findAll();
} 
