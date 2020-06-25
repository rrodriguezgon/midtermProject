package com.ironhack.midtermProject.exception;

import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FundsExceptionTest {

    private FundsException fundsException;
    @BeforeEach
    void setUp() {
        fundsException = new FundsException("mesagge");
    }

    @Test
    void test(){
        assertTrue(fundsException instanceof FundsException);
    }
}