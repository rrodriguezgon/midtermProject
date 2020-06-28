package com.ironhack.midtermProject.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CheckingAccountService;
import com.ironhack.midtermProject.service.CreditCardAccountService;
import com.ironhack.midtermProject.service.SavingAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", roles = {"ADMIN"})
class CreditCardAccountControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CreditCardAccountService creditCardAccountService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private CreditCardAccount account;

    private CreateCreditCardAccountDto createCreditCardAccountDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createCreditCardAccountDto = new CreateCreditCardAccountDto(new BigDecimal("1000"),
                new BigDecimal("0.1"), new BigDecimal("100"),
                1,2);

        account = new CreditCardAccount(new BigDecimal("1"),
                new BigDecimal("1"), new Money());
        account.setId(1);

        List<CreditCardAccount> list = Collections.singletonList(account);

        when(creditCardAccountService.findAll()).thenReturn(list);
        when(creditCardAccountService.getById(any(User.class), eq(account.getId()))).thenReturn(account);
        when(creditCardAccountService.Create(any(CreateCreditCardAccountDto.class))).thenReturn(account);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/credit-card-accounts"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/credit-card-account/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/credit-card-account")
                .content(objectMapper.writeValueAsString(createCreditCardAccountDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}