package com.ironhack.midtermProject.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Admin admin;

    @Test
    void constructor(){
        admin = new Admin();
        admin = new Admin("name", "password");
    }
}