package com.ironhack.midtermProject.controller.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreateTransferDtoTest {

    CreateTransferDto createTransferDto;
    @BeforeEach
    void setUp() {
        createTransferDto = new CreateTransferDto();
        createTransferDto = new CreateTransferDto(1, 1, "receiverAccountName", new BigDecimal("1"));
    }

    @Test
    void getEmitterAccountId() {
        Integer param = 1;
        createTransferDto.setEmitterAccountId(param);

        assertEquals(param, createTransferDto.getEmitterAccountId());
    }

    @Test
    void getReceiverAccountId() {
        Integer param = 1;
        createTransferDto.setReceiverAccountId(param);

        assertEquals(param, createTransferDto.getReceiverAccountId());
    }

    @Test
    void getReceiverAccountName() {
        String param = "receiverAccountName";
        createTransferDto.setReceiverAccountName(param);

        assertEquals(param, createTransferDto.getReceiverAccountName());
    }

    @Test
    void getAmount() {
        BigDecimal param = new BigDecimal("1");
        createTransferDto.setAmount(param);

        assertEquals(param, createTransferDto.getAmount());
    }
}