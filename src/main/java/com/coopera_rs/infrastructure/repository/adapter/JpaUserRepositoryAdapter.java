package com.coopera_rs.infrastructure.repository.adapter;

import com.coopera_rs.application.service.EmailService;
import com.coopera_rs.core.User;
import com.coopera_rs.core.port.UserRepository;
import com.coopera_rs.infrastructure.repository.ConfirmationTokenRepository;
import com.coopera_rs.infrastructure.repository.SpringDataUserRepository;
import com.coopera_rs.infrastructure.repository.entity.ConfirmationToken;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    public JpaUserRepositoryAdapter ( SpringDataUserRepository springDataUserRepository ) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save ( User user ) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = springDataUserRepository.save(entity);

        return UserMapper.toDomainDTO(savedEntity);
    }

    public User updateUser ( UserEntity user ) {
        UserEntity savedEntity = springDataUserRepository.save(user);
        return UserMapper.toDomainDTO(savedEntity);
    }

    @Override
    public Optional<User> findByEmail ( String email ) {
        return springDataUserRepository.findByEmail(email)
                .map(UserMapper::toDomainDTO);
    }

    @Override
    public Optional<User> findByUsername ( String username ) {
        return springDataUserRepository.findByUsername(username)
                .map(UserMapper::toDomainDTO);
    }

    @Override
    public User findById(UUID id){
        return springDataUserRepository.findById(id)
                .map(UserMapper::toDomainDTO)
                .orElse(null);
    }


    @Override
    public List<UserEntity> findAll () {
        return springDataUserRepository.findAll();
    }

    @Override
    public void updateEmailStatus(UUID userId, boolean verified) {
        Optional<UserEntity> userOptional = springDataUserRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setEmailVerified(true);
            springDataUserRepository.save(user);
        }
    }
}
