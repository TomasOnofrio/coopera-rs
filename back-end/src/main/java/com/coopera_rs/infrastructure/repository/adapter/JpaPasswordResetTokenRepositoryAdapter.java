package com.coopera_rs.infrastructure.repository.adapter;

import com.coopera_rs.core.port.PasswordResetTokenRepository;
import com.coopera_rs.infrastructure.repository.SpringDataPasswordResetTokenRepository;
import com.coopera_rs.infrastructure.repository.entity.PasswordResetTokenEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaPasswordResetTokenRepositoryAdapter implements PasswordResetTokenRepository {

    private final SpringDataPasswordResetTokenRepository springRepository;

    public JpaPasswordResetTokenRepositoryAdapter(SpringDataPasswordResetTokenRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Optional<PasswordResetTokenEntity> findByToken(String token) {
        return springRepository.findByToken(token);
    }

    @Override
    public void delete(PasswordResetTokenEntity token) {
        springRepository.delete(token);
    }
}
