package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.model.security.AccountHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    @BeforeEach
    void setUp() {
        account = new SavingsAccount();
    }

    @Test
    void getId() {
        Integer param = 1;
        account.setId(param);

        assertEquals(param, account.getId());
    }

    @Test
    void getBalance() {
        Money param = new Money(new BigDecimal("1"));
        account.setBalance(param);

        assertEquals(param, account.getBalance());
    }

    @Test
    void getPenaltyFee() {
        BigDecimal param = new BigDecimal("1");
        account.setPenaltyFee(param);

        assertEquals(param, account.getPenaltyFee());
    }

    @Test
    void getPrimaryOwner() {
        AccountHolder param = new AccountHolder();
        account.setPrimaryOwner(param);

        assertEquals(param, account.getPrimaryOwner());
    }

    @Test
    void getSecondaryOwner() {
        AccountHolder param = new AccountHolder();
        account.setSecondaryOwner(param);

        assertEquals(param, account.getSecondaryOwner());
    }

    @Test
    void getEmitterTranfers() {
        List<Transfer> param = new ArrayList<>();
        account.setEmitterTranfers(param);

        assertEquals(param, account.getEmitterTranfers());
    }

    @Test
    void getReceiverTransfers() {
        List<Transfer> param = new ArrayList<>();
        account.setReceiverTransfers(param);

        assertEquals(param, account.getReceiverTransfers());
    }

    @Test
    void getCreatedAt() {
        LocalDate param = LocalDate.now();
        account.setCreatedAt(param);

        assertEquals(param, account.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        LocalDate param = LocalDate.now();
        account.setUpdatedAt(param);

        assertEquals(param, account.getUpdatedAt());
    }

    @Test
    void getPENALTYFEE_DEFAULT(){
        BigDecimal PENALTYFEE_DEFAULT = new BigDecimal("40");
        assertEquals(PENALTYFEE_DEFAULT,account.getPENALTYFEE_DEFAULT());
    }
}