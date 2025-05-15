package com.coopera_rs.core.port;

import com.coopera_rs.infrastructure.repository.entity.PasswordResetTokenEntity;

import java.util.Optional;

public interface PasswordResetTokenRepository {
    Optional<PasswordResetTokenEntity> findByToken(String token);
    void delete(PasswordResetTokenEntity token);
}