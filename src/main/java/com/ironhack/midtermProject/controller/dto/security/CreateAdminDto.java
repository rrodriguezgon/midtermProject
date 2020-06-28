/**
 * com.ironhack.midtermProject.controller.dto.security;
 */
package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

/**
 * CreateAdminDto Class
 */
public class CreateAdminDto {
    @NotEmpty(message = "Name cannot be empty")
    String username;
    @NotEmpty(message = "Password cannot be empty")
    String password;

    /**
     * Default Constructor CreateAdminDto.
     */
    public CreateAdminDto(){}

    /**
     * Constructor CreateAdminDto
     * @param username username Admin.
     * @param password password Admin.
     */
    public CreateAdminDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter username of Admin
     * @return username of Admin
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter username of Admin
     * @param username username of Admin
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password of Admin
     * @return password of Admin
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password of Admin
     * @param password password of Admin
     */
    public void setPassword(String password) {
        this.password = password;
    }
}