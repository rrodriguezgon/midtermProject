package com.ironhack.midtermProject.handler;

import com.ironhack.midtermProject.exception.*;
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

    @Test
    void handleFraudException() {
            assertThrows(Exception.class, () ->  globalHandler.handleFraudException(new FraudException("Not found."), null));
    }

    @Test
    void handleResetDataException() {
        assertThrows(Exception.class, () ->  globalHandler.handleResetDataException(new ResetDataException("Not found."), null));
    }
}