package com.ironhack.midtermProject.controller.dto.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateThirdPartyDtoTest {

    private CreateThirdPartyDto createThirdPartyDto;

    @BeforeEach
    void setUp() {
        createThirdPartyDto = new CreateThirdPartyDto();
        createThirdPartyDto = new CreateThirdPartyDto("name", "password", "hashKey");
    }

    @Test
    void getUsername() {
        String param = "username";
        createThirdPartyDto.setName(param);

        assertEquals(param, createThirdPartyDto.getName());
    }

    @Test
    void getPassword() {
        String param = "password";
        createThirdPartyDto.setPassword(param);

        assertEquals(param, createThirdPartyDto.getPassword());
    }

    @Test
    void getHashKey() {
        String param = "hashKey";
        createThirdPartyDto.setHashKey(param);

        assertEquals(param, createThirdPartyDto.getHashKey());
    }
}