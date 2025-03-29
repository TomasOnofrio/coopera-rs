package com.coopera_rs.core;

import java.util.Objects;
import java.util.UUID;

public class User {
    
    private UUID id;
    private String email;
    private String username;
    private String password;
    private boolean emailVerified;


    public User() {
    }


    public User(UUID id, String email, String username, String password, boolean emailVerified) {
        this.id = id != null ? id : UUID.randomUUID();
        this.email = email;
        this.username = username;
        this.password = password;
        this.emailVerified = false;
    }



    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }
}
