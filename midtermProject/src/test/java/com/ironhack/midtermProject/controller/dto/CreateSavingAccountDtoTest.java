package com.ironhack.midtermProject.controller.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreateSavingAccountDtoTest {

    private CreateSavingAccountDto createSavingAccountDto;

    @BeforeEach
    void setUp() {
        createSavingAccountDto = new CreateSavingAccountDto();
        new CreateSavingAccountDto(new BigDecimal("1"),new BigDecimal("1"), "secretKey"
                ,1,2);
    }

    @Test
    void getBalance() {
        BigDecimal param = new BigDecimal("1");
        createSavingAccountDto.setBalance(param);

        assertEquals(param, createSavingAccountDto.getBalance());
    }

    @Test
    void getSecretKey() {
        String param = "secretKey";
        createSavingAccountDto.setSecretKey(param);

        assertEquals(param, createSavingAccountDto.getSecretKey());
    }

    @Test
    void getInterestRate() {
        BigDecimal param = new BigDecimal("1");
        createSavingAccountDto.setInterestRate(param);

        assertEquals(param, createSavingAccountDto.getInterestRate());
    }

    @Test
    void getPrimaryOwnerId() {
        Integer param = 1;
        createSavingAccountDto.setPrimaryOwnerId(param);

        assertEquals(param, createSavingAccountDto.getPrimaryOwnerId());
    }

    @Test
    void getSecondaryOwnerId() {
        Integer param = 1;
        createSavingAccountDto.setSecondaryOwnerId(param);

        assertEquals(param, createSavingAccountDto.getSecondaryOwnerId());
    }
}