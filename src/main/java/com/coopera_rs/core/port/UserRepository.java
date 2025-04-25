package com.coopera_rs.core.port;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;

public interface UserRepository {
    
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User findById(UUID id);
    List<UserEntity> findAll();
    void updateEmailStatus(UUID userId, boolean verified);
    User updateUser ( UserEntity user );
}
