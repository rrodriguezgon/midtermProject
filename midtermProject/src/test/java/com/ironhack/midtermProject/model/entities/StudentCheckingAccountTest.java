package com.ironhack.midtermProject.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StudentCheckingAccountTest {

    StudentCheckingAccount studentCheckingAccount;

    @BeforeEach
    void setUp() {
        studentCheckingAccount = new StudentCheckingAccount();
        studentCheckingAccount = new StudentCheckingAccount(new Money(new BigDecimal("0")),
                "secretKey");
    }

    @Test
    void getId() {
        int param = 1;
        studentCheckingAccount.setId(param);

        assertEquals(param,studentCheckingAccount.getId());
    }
}