package com.ironhack.midtermProject.controller.dto;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreateCheckingAccountDtoTest {

    private CreateCheckingAccountDto createCheckingAccountDto;

    @BeforeEach
    void setUp() {
        createCheckingAccountDto = new CreateCheckingAccountDto();
        createCheckingAccountDto = new CreateCheckingAccountDto(new BigDecimal("1"), "secretKey", 1, 1);
    }

    @Test
    void getBalance() {
        BigDecimal param = new BigDecimal("1");
        createCheckingAccountDto.setBalance(param);

        assertEquals(param, createCheckingAccountDto.getBalance());
    }

    @Test
    void getSecretKey() {
        String param = "secretKey";
        createCheckingAccountDto.setSecretKey(param);

        assertEquals(param, createCheckingAccountDto.getSecretKey());
    }

    @Test
    void getPrimaryOwnerId() {
        Integer param = 1;
        createCheckingAccountDto.setPrimaryOwnerId(param);

        assertEquals(param, createCheckingAccountDto.getPrimaryOwnerId());
    }

    @Test
    void getSecondaryOwnerId() {
        Integer param = 1;
        createCheckingAccountDto.setSecondaryOwnerId(param);

        assertEquals(param, createCheckingAccountDto.getSecondaryOwnerId());
    }
}