package com.ironhack.midtermProject.controller.dto.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAdminDtoTest {

    private CreateAdminDto createAdminDto;
    @BeforeEach
    void setUp() {
        createAdminDto = new CreateAdminDto();
        createAdminDto = new CreateAdminDto("username","password");
    }

    @Test
    void getUsername() {
        String param = "username";
        createAdminDto.setUsername(param);

        assertEquals(param, createAdminDto.getUsername());
    }

    @Test
    void getPassword() {
        String param = "password";
        createAdminDto.setPassword(param);

        assertEquals(param, createAdminDto.getPassword());
    }
}