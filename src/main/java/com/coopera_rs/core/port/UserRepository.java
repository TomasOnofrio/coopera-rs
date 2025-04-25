package com.coopera_rs.core.port;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.coopera_rs.core.User;

public interface UserRepository {
    
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User findById(UUID id);
    List<User> findAll();
    boolean updateEmailVerifiedStatus(UUID userId, boolean verified);
}
