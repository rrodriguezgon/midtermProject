/**
 * com.ironhack.midtermProject.controller.dto.security
 */
package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
public class CreateThirdPartyDto {
    @NotEmpty(message = "Name cannot be empty")
    String name;
    @NotEmpty(message = "Password cannot be empty")
    String password;
    @NotEmpty(message = "HashKey cannot be empty")
    String hashKey;

    /**
     *
     */
    public CreateThirdPartyDto(){}

    /**
     *
     * @param name
     * @param password
     * @param hashKey
     */
    public CreateThirdPartyDto(String name, String password, String hashKey) {
        this.name = name;
        this.password = password;
        this.hashKey = hashKey;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     *
     * @return
     */
    public String getHashKey() {
        return hashKey;
    }

    /**
     *
     * @param hashKey
     */
    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}