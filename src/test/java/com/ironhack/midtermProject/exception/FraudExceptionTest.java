package com.ironhack.midtermProject.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraudExceptionTest {

    private FraudException fraudException;
    @BeforeEach
    void setUp() {
        fraudException = new FraudException("message");
    }

    @Test
    void test(){
        assertTrue(fraudException instanceof FraudException);
    }
}