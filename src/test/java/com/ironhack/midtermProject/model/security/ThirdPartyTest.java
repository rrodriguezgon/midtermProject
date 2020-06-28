package com.ironhack.midtermProject.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdPartyTest {

    ThirdParty thirdParty;
    @BeforeEach
    void setUp() {
        thirdParty = new ThirdParty();
        thirdParty = new ThirdParty("name", "password", "hashKey");
    }

    @Test
    void getHashKey() {
        String param = "";
        thirdParty.setHashKey(param);

        assertEquals(param,thirdParty.getHashKey());
    }
}