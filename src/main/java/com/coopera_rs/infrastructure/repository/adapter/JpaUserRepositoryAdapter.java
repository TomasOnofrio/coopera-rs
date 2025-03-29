package com.coopera_rs.infrastructure.repository.adapter;

import com.coopera_rs.core.User;
import com.coopera_rs.core.port.UserRepository;
import com.coopera_rs.infrastructure.repository.SpringDataUserRepository;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;
import com.coopera_rs.infrastructure.repository.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public JpaUserRepositoryAdapter ( SpringDataUserRepository springDataUserRepository ) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save ( User user ) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = springDataUserRepository.save(entity);
        return UserMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByEmail ( String email ) {
        return springDataUserRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername ( String username ) {
        return springDataUserRepository.findByUsername(username)
                .map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll () {
        return springDataUserRepository.findAll()
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }
}
