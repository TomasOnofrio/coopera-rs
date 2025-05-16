package com.coopera_rs.core.port;

import java.util.List;
import java.util.Optional;

import com.coopera_rs.core.domain.User;

public interface UserRepository {
    
    User save(User user);
    Optional<User> findByEmail(String email);
    List<User> findAll();
} 
