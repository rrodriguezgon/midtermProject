package com.ironhack.midtermProject.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount checkingAccount;
    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount();
        checkingAccount = new CheckingAccount(new Money(), "secretKey");
    }

    @Test
    void getMinimumBalance() {
        BigDecimal param = new BigDecimal("250");

        assertEquals(param, checkingAccount.getMinimumBalance());
    }

    @Test
    void getMonthlyMaintenanceFee() {
        int param = 12;

        assertEquals(param, checkingAccount.getMonthlyMaintenanceFee());
    }

    @Test
    void getMINIMUM_BALANCE_DEFAULT(){
        BigDecimal MINIMUM_BALANCE_DEFAULT = new BigDecimal("250");

        assertEquals(MINIMUM_BALANCE_DEFAULT,checkingAccount.getMINIMUM_BALANCE_DEFAULT());
    }

    @Test
    void getMONTLYMAINTENANCEFEE_DEFAULT(){
        int MONTLYMAINTENANCEFEE_DEFAULT = 12;

        assertEquals(MONTLYMAINTENANCEFEE_DEFAULT, checkingAccount.getMONTLYMAINTENANCEFEE_DEFAULT());
    }
}