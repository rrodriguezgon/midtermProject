package com.ironhack.midtermProject.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResetDataExceptionTest {
    private ResetDataException resetDataException;
    @BeforeEach
    void setUp() {
        resetDataException = new ResetDataException("mesagge");
    }

    @Test
    void test(){
        assertTrue(resetDataException instanceof ResetDataException);
    }

}