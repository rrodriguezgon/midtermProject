/**
 *
 */
package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
public class CreateAdminDto {
    @NotEmpty(message = "Name cannot be empty")
    String username;
    @NotEmpty(message = "Password cannot be empty")
    String password;

    /**
     *
     */
    public CreateAdminDto(){}

    /**
     *
     * @param username
     * @param password
     */
    public CreateAdminDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}