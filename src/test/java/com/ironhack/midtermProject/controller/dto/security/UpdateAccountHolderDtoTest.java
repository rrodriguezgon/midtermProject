package com.ironhack.midtermProject.controller.dto.security;

import com.ironhack.midtermProject.model.security.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UpdateAccountHolderDtoTest {

    UpdateAccountHolderDto updateAccountHolderDto;
    @BeforeEach
    void setUp() {
        updateAccountHolderDto = new UpdateAccountHolderDto();
        updateAccountHolderDto = new UpdateAccountHolderDto("firstName", "lastName",
                LocalDate.now(), new Address(), "mailingAddress");
    }

    @Test
    void getFirstName() {
        String param = "firstName";
        updateAccountHolderDto.setFirstName(param);

        assertEquals(param, updateAccountHolderDto.getFirstName());
    }

    @Test
    void getLastName() {
        String param = "lastName";
        updateAccountHolderDto.setLastName(param);

        assertEquals(param, updateAccountHolderDto.getLastName());
    }

    @Test
    void getBirthday() {
        LocalDate param = LocalDate.now();
        updateAccountHolderDto.setBirthday(param);

        assertEquals(param, updateAccountHolderDto.getBirthday());
    }

    @Test
    void getPrimaryAddress() {
        Address param = new Address();
        updateAccountHolderDto.setPrimaryAddress(param);

        assertEquals(param, updateAccountHolderDto.getPrimaryAddress());
    }

    @Test
    void getMailingAddress() {
        String param = "mailingAddress";
        updateAccountHolderDto.setMailingAddress(param);

        assertEquals(param, updateAccountHolderDto.getMailingAddress());
    }
}