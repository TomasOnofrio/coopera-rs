package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setEmailVerified(user.getEmailVerified());
        return entity;
    }

    public static User toDomainDTO(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getUsername(),
            entity.getPassword(),
            entity.getEmail(),
            entity.getEmailVerified()
        );
    }

    public static User toDomainDTO(RegisterUserDTO dto) {
        return new User(
            null, 
            dto.getUsername(),
            dto.getPassword(),
            dto.getEmail(),
            false
        );
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getEmailVerified()
        );
    }

    public static UserResponseDTO entityToResponseDTO(UserEntity user) {
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getEmailVerified()
        );
    }
}