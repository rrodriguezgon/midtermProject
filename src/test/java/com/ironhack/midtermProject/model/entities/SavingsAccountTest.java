package com.ironhack.midtermProject.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    SavingsAccount savingsAccount;
    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount();
        savingsAccount = new SavingsAccount(new Money(new BigDecimal("0")),
                "secretKey", new BigDecimal("0"));
        savingsAccount = new SavingsAccount(new Money(new BigDecimal("0")),
                "secretKey", null);
    }

    @Test
    void getInterestRate() {
        BigDecimal param = new BigDecimal("0");
        savingsAccount.setInterestRate(param);

        assertEquals(param,savingsAccount.getInterestRate());
    }

    @Test
    void getMinimumBalance() {
        BigDecimal param = new BigDecimal("0");
        savingsAccount.setMinimumBalance(param);

        assertEquals(param,savingsAccount.getMinimumBalance());
    }

    @Test
    void getMIN_RATE() {
        BigDecimal MIN_RATE = new BigDecimal("0.0025");

        assertEquals(MIN_RATE,savingsAccount.getMIN_RATE());
    }
}