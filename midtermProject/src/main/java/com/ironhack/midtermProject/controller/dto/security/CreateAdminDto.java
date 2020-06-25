package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

public class CreateAdminDto {
    @NotEmpty(message = "Name cannot be empty")
    String username;
    @NotEmpty(message = "Password cannot be empty")
    String password;

    public CreateAdminDto(){}

    public CreateAdminDto(String username, String password) {
        this.username = username;
        this.password = password;
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
}
