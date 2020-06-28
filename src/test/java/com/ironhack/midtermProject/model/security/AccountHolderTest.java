package com.ironhack.midtermProject.model.security;

import com.ironhack.midtermProject.model.entities.Account;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountHolderTest {

    AccountHolder accountHolder;
    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder();
        accountHolder = new AccountHolder("username", "password", "firstName", "lastName",
                LocalDate.now(), new Address() , "mailingAddress");
    }

    @Test
    void getBirthday() {
        LocalDate param = LocalDate.now();
        accountHolder.setBirthday(param);

        assertEquals(param,accountHolder.getBirthday());
    }

    @Test
    void getPrimaryAddress() {
        Address param = new Address();
        accountHolder.setPrimaryAddress(param);

        assertEquals(param,accountHolder.getPrimaryAddress());
    }

    @Test
    void getMailingAddress() {
        String param = "";
        accountHolder.setMailingAddress(param);

        assertEquals(param,accountHolder.getMailingAddress());
    }

    @Test
    void getAccountsPrimary() {
        List<Account> param = new ArrayList<>();
        accountHolder.setAccountsPrimary(param);

        assertEquals(param,accountHolder.getAccountsPrimary());
    }

    @Test
    void getFirstName() {
        String param = "";
        accountHolder.setFirstName(param);

        assertEquals(param,accountHolder.getFirstName());
    }

    @Test
    void getLastName() {
        String param = "";
        accountHolder.setLastName(param);

        assertEquals(param,accountHolder.getLastName());
    }

    @Test
    void getFirstAndLastnName() {
        String param = "firstName lastName";

        assertEquals(param,accountHolder.getFirstAndLastnName());
    }

    @Test
    void getAccountsSecondary() {
        List<Account> param = new ArrayList<>();
        accountHolder.setAccountsSecondary(param);

        assertEquals(param,accountHolder.getAccountsSecondary());
    }
}