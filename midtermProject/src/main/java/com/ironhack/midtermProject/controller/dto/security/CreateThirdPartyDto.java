package com.ironhack.midtermProject.controller.dto.security;

import javax.validation.constraints.NotEmpty;

public class CreateThirdPartyDto {
    @NotEmpty(message = "Name cannot be empty")
    String name;
    @NotEmpty(message = "Password cannot be empty")
    String password;
    @NotEmpty(message = "HashKey cannot be empty")
    String hashKey;

    public CreateThirdPartyDto(){}

    public CreateThirdPartyDto(String name, String password, String hashKey) {
        this.name = name;
        this.password = password;
        this.hashKey = hashKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}