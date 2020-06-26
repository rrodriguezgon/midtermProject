package com.ironhack.midtermProject.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    @BeforeEach
    void setUp() {
        user = new AccountHolder();
    }

    @Test
    void getId() {
        int param = 1;
        user.setId(param);

        assertEquals(param,user.getId());
    }

    @Test
    void getUsername() {
        String param = "";
        user.setUsername(param);

        assertEquals(param,user.getUsername());
    }

    @Test
    void getPassword() {
        String param = "";
        user.setPassword(param);

        assertEquals(param,user.getPassword());
    }

    @Test
    void getRoles() {
        HashSet<Role> param = new HashSet<>();
        user.setRoles(param);

        assertEquals(param,user.getRoles());
    }
}