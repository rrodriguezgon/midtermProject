package com.ironhack.midtermProject.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityAccessExceptionTest {

    private SecurityAccessException securityAccessException;

    @BeforeEach
    void setUp() {
        securityAccessException = new SecurityAccessException("message");
    }

    @Test
    void test(){
        assertTrue(securityAccessException instanceof SecurityAccessException);
    }
}