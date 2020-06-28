package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.model.security.Role;

import java.util.HashSet;
import java.util.Set;

public abstract class UserViewModel {
    protected Integer id;

    protected String username;
    protected String password;
    private String roles;

    public UserViewModel(Integer id, String username, String password, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
