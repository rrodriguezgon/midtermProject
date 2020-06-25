package com.ironhack.midtermProject.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataNotFoundExceptionTest {

    private DataNotFoundException dataNotFoundException;
    @BeforeEach
    void setUp() {
        dataNotFoundException = new DataNotFoundException("message");
    }

    @Test
    void test(){
        assertTrue(dataNotFoundException instanceof DataNotFoundException);
    }
}