package com.coopera_rs.core.domain;

import com.coopera_rs.core.enums.Role;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    
    private Long id;
    private Role role;
    private String email;
    private String name;
    private String phone;
    private boolean isVerified;
    private String salt;
    private String password;
    private LocalDateTime lastUpdated;
    private boolean isActive;

    public User(Long id, Role role, String email, String name, String phone, boolean isVerified, String salt, String password, LocalDateTime lastUpdated, boolean isActive) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.isVerified = isVerified;
        this.salt = salt;
        this.password = password;
        this.lastUpdated = lastUpdated;
        this.isActive = isActive;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
