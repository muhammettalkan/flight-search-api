package com.alkan.flightsearch.domain.user.impl;

import com.alkan.flightsearch.library.enums.Role;
import com.alkan.flightsearch.library.rest.AbstractEntity;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String password;
    private Role authority;


    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role role) {
        this.authority = role;
    }


}
