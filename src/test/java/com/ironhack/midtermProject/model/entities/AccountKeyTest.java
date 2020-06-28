package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountKeyTest {

    AccountKey accountKey;
    @BeforeEach
    void setUp() {
        accountKey = new SavingsAccount();
    }

    @Test
    void getSecretKey() {
        String param = "secretKey";

        accountKey.setSecretKey(param);
        assertEquals(param,accountKey.getSecretKey());
    }

    @Test
    void getStatus() {
        StatusAccount param = StatusAccount.ACTIVE;
        accountKey.setStatus(param);

        assertEquals(param, accountKey.getStatus());
    }
}