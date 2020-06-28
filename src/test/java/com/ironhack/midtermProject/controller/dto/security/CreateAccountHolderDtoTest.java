package com.ironhack.midtermProject.controller.dto.security;

import com.ironhack.midtermProject.model.security.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreateAccountHolderDtoTest {

    private CreateAccountHolderDto createAccountHolderDto;

    @BeforeEach
    void setUp() {
        createAccountHolderDto = new CreateAccountHolderDto();
        createAccountHolderDto = new CreateAccountHolderDto("username", "password", "firstName", "lastName",
                LocalDate.now(), new Address(), "mailingAddress");
    }

    @Test
    void getUsername() {
        String param = "username";
        createAccountHolderDto.setUsername(param);

        assertEquals(param, createAccountHolderDto.getUsername());
    }

    @Test
    void getFirstName() {
        String param = "firstName";
        createAccountHolderDto.setFirstName(param);

        assertEquals(param, createAccountHolderDto.getFirstName());
    }

    @Test
    void getLastName() {
        String param = "lastName";
        createAccountHolderDto.setLastName(param);

        assertEquals(param, createAccountHolderDto.getLastName());
    }

    @Test
    void getPassword() {
        String param = "password";
        createAccountHolderDto.setPassword(param);

        assertEquals(param, createAccountHolderDto.getPassword());
    }

    @Test
    void getBirthday() {
        LocalDate param = LocalDate.now();
        createAccountHolderDto.setBirthday(param);

        assertEquals(param, createAccountHolderDto.getBirthday());
    }

    @Test
    void getPrimaryAddress() {
        Address param = new Address();
        createAccountHolderDto.setPrimaryAddress(param);

        assertEquals(param, createAccountHolderDto.getPrimaryAddress());
    }

    @Test
    void getMailingAddress() {
        String param = "mailingAddress";
        createAccountHolderDto.setMailingAddress(param);

        assertEquals(param, createAccountHolderDto.getMailingAddress());
    }
}