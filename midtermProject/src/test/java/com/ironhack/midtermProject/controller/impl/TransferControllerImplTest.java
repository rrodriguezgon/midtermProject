package com.ironhack.midtermProject.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.controller.dto.CreateTransactionDto;
import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.enums.TypeTransaction;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.entities.Transfer;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.TransferService;
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
import java.util.Calendar;
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
class TransferControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private TransferService transferService;

    private Transfer transfer;

    private CreateTransferDto createTransferDto;

    private CreateTransactionDto createTransactionDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createTransactionDto = new CreateTransactionDto(1, new BigDecimal("1"), "secretKey", TypeTransaction.CREDIT);
        createTransferDto = new CreateTransferDto(1, 1, "receiverAccountName", new BigDecimal("1"));
        transfer = new Transfer(Calendar.getInstance().getTime(), new BigDecimal("0"));

        List<Transfer> list = Collections.singletonList(transfer);

        when(transferService.findAll()).thenReturn(list);
        when(transferService.findAlllByUserId(1)).thenReturn(list);
        when(transferService.createTransfer(any(User.class), any(CreateTransferDto.class))).thenReturn(transfer);
        when(transferService.createTransaction(any(User.class), any(CreateTransactionDto.class),eq("hashkey"))).thenReturn(transfer);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/transfers"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/transfers/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllByIdUser( ) throws Exception{
        mockMvc.perform(get("/transfer/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createTransfer() throws Exception {
        mockMvc.perform(post("/transfer")
                .content(objectMapper.writeValueAsString(createTransferDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void createTransaction() throws Exception {
        mockMvc.perform(post("/transaction").header("hashKey","hashKey")
                .content(objectMapper.writeValueAsString(createTransactionDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}