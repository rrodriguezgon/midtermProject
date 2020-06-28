package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.User;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransferTest {

    Transfer transfer;
    @BeforeEach
    void setUp() {
        transfer = new Transfer();
        transfer = new Transfer(Calendar.getInstance().getTime(), new BigDecimal("0"));
    }

    @Test
    void getId() {
        int param = 1;
        transfer.setId(param);

        assertEquals(param,transfer.getId());
    }

    @Test
    void getDateTransfer() {
        Date param = Calendar.getInstance().getTime();
        transfer.setDateTransfer(Calendar.getInstance().getTime());

        assertEquals(param,transfer.getDateTransfer());
    }

    @Test
    void getEmitteraccount() {
        Account param = new SavingsAccount();

        transfer.setEmitteraccount(param);

        assertEquals(param,transfer.getEmitteraccount());
    }

    @Test
    void getReceiverAccount() {
        Account param = new SavingsAccount();
        transfer.setReceiverAccount(param);

        assertEquals(param,transfer.getReceiverAccount());
    }

    @Test
    void getAmount() {
        BigDecimal param = new BigDecimal("0");
        transfer.setAmount(param);

        assertEquals(param,transfer.getAmount());
    }

    @Test
    void getEmitterUser() {
        User param = new Admin();
        transfer.setEmitterUser(param);

        assertEquals(param,transfer.getEmitterUser());
    }
}