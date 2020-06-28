package com.ironhack.midtermProject.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.entities.CheckingAccount;
import com.ironhack.midtermProject.model.entities.Money;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CheckingAccountService;
import com.ironhack.midtermProject.service.security.ThirdPartyService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", roles = {"ADMIN"})
class CheckingAccountControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CheckingAccountService checkingAccountService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Account account;

    private CreateCheckingAccountDto createCheckingAccountDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createCheckingAccountDto = new CreateCheckingAccountDto(new BigDecimal("1"), "secretKey",
                1, 1);

        account = new CheckingAccount(new Money(), "secretKey");
        account.setId(1);

        List<Account> list = Collections.singletonList(account);

        when(checkingAccountService.findAll()).thenReturn(list);
        when(checkingAccountService.findById(any(User.class), eq(account.getId()))).thenReturn(account);
        when(checkingAccountService.Create(any(CreateCheckingAccountDto.class))).thenReturn(account);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/checking-accounts"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/checking-account/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/checking-account")
                .content(objectMapper.writeValueAsString(createCheckingAccountDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}