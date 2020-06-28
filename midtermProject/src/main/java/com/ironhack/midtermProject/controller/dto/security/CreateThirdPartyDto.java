/**
 * com.ironhack.midtermProject.controller.dto.security
 */
package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

/**
 * CreateThirdPartyDto Class
 */
public class CreateThirdPartyDto {
    @NotEmpty(message = "UserName cannot be empty")
    String username;
    @NotEmpty(message = "Password cannot be empty")
    String password;
    @NotEmpty(message = "HashKey cannot be empty")
    String hashKey;

    /**
     * Default Constuctor CreateThirdPartyDto.
     */
    public CreateThirdPartyDto(){}

    /**
     * Constructor CreateThirdPartyDto.
     * @param username username ThirdParty.
     * @param password password ThirdParty.
     * @param hashKey
     */
    public CreateThirdPartyDto(String username, String password, String hashKey) {
        this.username = username;
        this.password = password;
        this.hashKey = hashKey;
    }

    /**
     * Getter username ThirdParty
     * @return username ThirdParty
     */
    public String getUserName() {
        return username;
    }

    /**
     * Setter username ThirdParty
     * @param username username ThirdParty
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * Getter password ThirdParty
     * @return password ThirdParty
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password ThirdParty
     * @param password password ThirdParty
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter hashKey ThirdParty
     * @return hashKey ThirdParty
     */
    public String getHashKey() {
        return hashKey;
    }

    /**
     * Setter hashKey ThirdParty
     * @param hashKey hashKey ThirdParty
     */
    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}