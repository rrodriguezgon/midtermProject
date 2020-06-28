package com.ironhack.midtermProject.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Address address;
    @BeforeEach
    void setUp() {
        address = new Address();
        address = new Address("number", "street", "city", "country");
    }

    @Test
    void getNumber() {
        String param = "";
        address.setNumber(param);

        assertEquals(param,address.getNumber());
    }

    @Test
    void getStreet() {
        String param = "";
        address.setStreet(param);

        assertEquals(param,address.getStreet());
    }

    @Test
    void getCity() {
        String param = "";
        address.setCity(param);

        assertEquals(param,address.getCity());
    }

    @Test
    void getCountry() {
        String param = "";
        address.setCountry(param);

        assertEquals(param,address.getCountry());
    }
}