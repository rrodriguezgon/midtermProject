package com.ironhack.midtermProject.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserExistExceptionTest {

    private UserExistException userExistException;
    @BeforeEach
    void setUp() {
        userExistException = new UserExistException("message");
    }

    @Test
    void test(){
        assertTrue(userExistException instanceof UserExistException);
    }
}