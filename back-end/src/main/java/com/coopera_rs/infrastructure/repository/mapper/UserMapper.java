package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.domain.User;
import com.coopera_rs.core.enums.Role;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;
import com.coopera_rs.web.dto.RegisterUserDTO;
import com.coopera_rs.web.dto.UserResponseDTO;
import org.springframework.expression.spel.ast.NullLiteral;

import java.time.LocalDateTime;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();

        entity.setId(user.getId());
        entity.setRole(user.getRole());
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
        entity.setVerified(user.isVerified());
        entity.setSalt(user.getSalt());
        entity.setPassword(user.getPassword());
        entity.setLastUpdated(user.getLastUpdated());
        entity.setActive(user.isActive());

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getRole(),
            entity.getEmail(),
            entity.getName(),
            entity.getPhone(),
            entity.isVerified(),
            entity.getSalt(),
            entity.getPassword(),
            entity.getLastUpdated(),
            entity.isActive()
        );
    }

    public static User toDomain(RegisterUserDTO dto) {
        return new User(
            null,
            Role.CLIENT,
            dto.getEmail(),
            dto.getName(),
            dto.getPhone(),
            false,
            null,
            dto.getPassword(),
            LocalDateTime.now(),
            true
        );
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getName(),
            user.getRole(),
            user.getPhone(),
            user.isVerified(),
            user.isActive()
        );
    }
}