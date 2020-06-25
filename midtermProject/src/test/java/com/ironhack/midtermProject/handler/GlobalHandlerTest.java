package com.ironhack.midtermProject.handler;

import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.FundsException;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.exception.UserExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalHandlerTest {

    private GlobalHandler globalHandler;
    @BeforeEach
    void setUp() {
        globalHandler = new GlobalHandler();
    }

    @Test
    void handleDataNotFoundException() {
        assertThrows(Exception.class, () ->  globalHandler.handleDataNotFoundException(new DataNotFoundException("Not found."), null));
    }

    @Test
    void handleSecurityAccessException() {
        assertThrows(Exception.class, () ->  globalHandler.handleSecurityAccessException(new SecurityAccessException("Not found."), null));
    }

    @Test
    void handleFundsException() {
        assertThrows(Exception.class, () ->  globalHandler.handleFundsException(new FundsException("Not found."), null));
    }

    @Test
    void handleUserExistException() {
        assertThrows(Exception.class, () ->  globalHandler.handleUserExistException(new UserExistException("Not found."), null));
    }
}