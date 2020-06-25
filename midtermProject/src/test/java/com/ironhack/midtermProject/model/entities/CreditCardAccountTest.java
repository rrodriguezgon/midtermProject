package com.ironhack.midtermProject.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardAccountTest {

    CreditCardAccount creditCardAccount;
    @BeforeEach
    void setUp() {
        creditCardAccount = new CreditCardAccount();
        creditCardAccount = new CreditCardAccount(new BigDecimal("1"),
                new BigDecimal("1"), new Money());
        creditCardAccount = new CreditCardAccount(null,
                null, new Money());
    }

    @Test
    void getMIN_CREDITLIMIT() {
        BigDecimal MIN_CREDITLIMIT = new BigDecimal("100");

        assertEquals(MIN_CREDITLIMIT,creditCardAccount.getMIN_CREDITLIMIT());
    }

    @Test
    void getMIN_RATE() {
        BigDecimal MIN_RATE = new BigDecimal("0.2");

        assertEquals(MIN_RATE, creditCardAccount.getMIN_RATE());
    }

    @Test
    void getCreditLimit() {
        BigDecimal param = new BigDecimal("0");
        creditCardAccount.setCreditLimit(param);

        assertEquals(param,creditCardAccount.getCreditLimit());
    }

    @Test
    void getInterestRate() {
        BigDecimal param = new BigDecimal("0");
        creditCardAccount.setInterestRate(param);

        assertEquals(param,creditCardAccount.getInterestRate());
    }
}