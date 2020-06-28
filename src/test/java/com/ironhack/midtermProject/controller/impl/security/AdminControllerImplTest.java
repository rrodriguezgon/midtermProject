package com.ironhack.midtermProject.controller.impl.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.model.viewModel.AdminViewModel;
import com.ironhack.midtermProject.service.security.AdminService;
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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", roles = {"ADMIN"})
class AdminControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AdminService adminService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private AdminViewModel admin;

    private CreateAdminDto createAdminDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createAdminDto = new CreateAdminDto("username","password");

        admin = new AdminViewModel(1,"admin","pass","");
        admin.setId(1);

        List<AdminViewModel> list = Collections.singletonList(admin);

        when(adminService.findAll()).thenReturn(list);
        when(adminService.getById(admin.getId())).thenReturn(admin);
        when(adminService.Create(any(CreateAdminDto.class))).thenReturn(admin);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].username").value("admin")) ;
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/admin/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/admin")
                .content(objectMapper.writeValueAsString(createAdminDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/admin/1")
                .content(objectMapper.writeValueAsString(createAdminDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/admin/1")
        ).andExpect(status().isNoContent());
    }
}