package com.ironhack.midtermProject.controller.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreateCreditCardAccountDtoTest {

    private CreateCreditCardAccountDto createCreditCardAccountDto;

    @BeforeEach
    void setUp() {
        createCreditCardAccountDto = new CreateCreditCardAccountDto();
        createCreditCardAccountDto = new CreateCreditCardAccountDto(new BigDecimal("1"),
                new BigDecimal("1"), new BigDecimal("1"),
                1,1);
    }

    @Test
    void getCreditLimit() {
        BigDecimal param = new BigDecimal("1");
        createCreditCardAccountDto.setCreditLimit(param);

        assertEquals(param, createCreditCardAccountDto.getCreditLimit());
    }

    @Test
    void getInterestRate() {
        BigDecimal param = new BigDecimal("1");
        createCreditCardAccountDto.setInterestRate(param);

        assertEquals(param, createCreditCardAccountDto.getInterestRate());
    }

    @Test
    void getBalance() {
        BigDecimal param = new BigDecimal("1");
        createCreditCardAccountDto.setBalance(param);

        assertEquals(param, createCreditCardAccountDto.getBalance());
    }

    @Test
    void getPrimaryOwnerId() {
        Integer param = 1;
        createCreditCardAccountDto.setPrimaryOwnerId(param);

        assertEquals(param, createCreditCardAccountDto.getPrimaryOwnerId());
    }

    @Test
    void getSecondaryOwnerId() {
        Integer param = 1;
        createCreditCardAccountDto.setSecondaryOwnerId(param);

        assertEquals(param, createCreditCardAccountDto.getSecondaryOwnerId());
    }
}