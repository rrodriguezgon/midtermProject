package com.ironhack.midtermProject.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    Role role;
    @BeforeEach
    void setUp() {
        role = new Role();
        role = new Role("role");
    }

    @Test
    void getId() {
        int param = 1;
        role.setId(param);

        assertEquals(param,role.getId());
    }

    @Test
    void getRole() {
        String param = "";
        role.setRole(param);

        assertEquals(param,role.getRole());
    }

    @Test
    void getUser() {
        User param = new AccountHolder();
        role.setUser(param);

        assertEquals(param, role.getUser());
    }
}