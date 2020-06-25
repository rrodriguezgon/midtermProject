package com.ironhack.midtermProject.controller.impl.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.service.security.AccountHolderService;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", roles = {"ADMIN"})
class AccountHolderControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AccountHolderService accountHolderService;

    @MockBean
    private AdminRepository adminRepository;

    private MockMvc mockMvc;

    private AccountHolder  accountHolder;

    private CreateAccountHolderDto createAccountHolderDto;

    private UpdateAccountHolderDto updateAccountHolderDto;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("user","password", "firstname",
                "lastname", LocalDate.now(),new Address(),"");
        accountHolder.setId(1);
        createAccountHolderDto =
                new CreateAccountHolderDto("username", "password", "firstName", "lastName",
                        LocalDate.parse("1999-02-02"), new Address("number","street",
                        "city","country"), "mailingAddress");

        updateAccountHolderDto =
                new UpdateAccountHolderDto("firstName", "lastName",
                        LocalDate.now(), new Address(), "mailingAddress");

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        Admin admin = new Admin("admin","password");

        List<AccountHolder> list = Collections.singletonList(accountHolder);

       // when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);

        when(accountHolderService.findAll()).thenReturn(list);
        when(accountHolderService.findById(any(User.class), eq(accountHolder.getId()))).thenReturn(accountHolder);
        when(accountHolderService.Create(any(CreateAccountHolderDto.class))).thenReturn(accountHolder);
        when(accountHolderService.update(any(User.class), eq(accountHolder.getId()),any(UpdateAccountHolderDto.class))).thenReturn(accountHolder);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/accounts-holder"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].username").value("user")) ;
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/accounts-holder/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/accounts-holder")
                .content(objectMapper.writeValueAsString(createAccountHolderDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/accounts-holder/1")
                .content(objectMapper.writeValueAsString(createAccountHolderDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/accounts-holder/1")
        ).andExpect(status().isNoContent());
    }
}