package com.ironhack.midtermProject.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.Money;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.User;
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
class SavingAccountControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SavingAccountService savingAccountService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private SavingsAccount account;

    private CreateSavingAccountDto createSavingAccountDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createSavingAccountDto =
                new CreateSavingAccountDto(new BigDecimal("0.4"),new BigDecimal("150"), "secretKey"
                        ,1,2);

        account = new SavingsAccount(new Money(new BigDecimal("0")),
                "secretKey", new BigDecimal("0"));
        account.setId(1);

        List<SavingsAccount> list = Collections.singletonList(account);

        when(savingAccountService.findAll()).thenReturn(list);
        when(savingAccountService.getById(any(User.class), eq(account.getId()))).thenReturn(account);
        when(savingAccountService.Create(any(CreateSavingAccountDto.class))).thenReturn(account);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/savings-accounts"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/savings-account/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/savings-account")
                .content(objectMapper.writeValueAsString(createSavingAccountDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}