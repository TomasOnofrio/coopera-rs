package com.coopera_rs.web.dto;

import com.coopera_rs.core.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserResponseDTO {

    private long id;
    private String email;
    private String name;
    private Role role;
    private String phone;
    private boolean isVerified;
    private boolean isActive;

    public UserResponseDTO() {
    }

    public UserResponseDTO(long id, String email, String name, Role role, String phone, boolean isVerified, boolean isActive) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.phone = phone;
        this.isVerified = isVerified;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}