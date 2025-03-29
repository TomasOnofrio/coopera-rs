package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.User;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmailVerified(user.getEmailVerified());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getUsername(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getEmailVerified()
        );
    }

    public static User toDomain(RegisterUserDTO dto) {
        return new User(
            null, 
            dto.getUsername(),
            dto.getEmail(),
            dto.getPassword(),
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
}