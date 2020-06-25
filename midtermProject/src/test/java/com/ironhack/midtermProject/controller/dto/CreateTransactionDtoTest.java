package com.ironhack.midtermProject.controller.dto;

import com.ironhack.midtermProject.enums.TypeTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreateTransactionDtoTest {

    CreateTransactionDto createTransactionDto;
    @BeforeEach
    void setUp() {
        createTransactionDto = new CreateTransactionDto();
        createTransactionDto = new CreateTransactionDto(1, new BigDecimal("1"), "secretKey", TypeTransaction.CREDIT);
    }

    @Test
    void getAccountId() {
        Integer param = 1;
        createTransactionDto.setAccountId(param);

        assertEquals(param, createTransactionDto.getAccountId());
    }

    @Test
    void getAmount() {
        BigDecimal param = new BigDecimal("1");
        createTransactionDto.setAmount(param);

        assertEquals(param, createTransactionDto.getAmount());
    }

    @Test
    void getSecretKey() {
        String param = "secretKey";
        createTransactionDto.setSecretKey(param);

        assertEquals(param, createTransactionDto.getSecretKey());
    }

    @Test
    void getTypeTransaction() {
        TypeTransaction param = TypeTransaction.DEBIT;
        createTransactionDto.setTypeTransaction(param);

        assertEquals(param, createTransactionDto.getTypeTransaction());
    }
}