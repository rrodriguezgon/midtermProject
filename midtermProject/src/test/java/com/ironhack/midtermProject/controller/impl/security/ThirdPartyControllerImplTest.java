package com.ironhack.midtermProject.controller.impl.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.service.security.AdminService;
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
class ThirdPartyControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ThirdPartyService thirdPartyService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ThirdParty thirdParty;

    private CreateThirdPartyDto createThirdPartyDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        createThirdPartyDto = new CreateThirdPartyDto("name", "password", "hashKey");

        thirdParty = new ThirdParty("name", "password", "hashKey");
        thirdParty.setId(1);

        List<ThirdParty> list = Collections.singletonList(thirdParty);

        when(thirdPartyService.findAll()).thenReturn(list);
        when(thirdPartyService.findById(thirdParty.getId())).thenReturn(thirdParty);
        when(thirdPartyService.Create(any(CreateThirdPartyDto.class))).thenReturn(thirdParty);
        when(thirdPartyService.update(eq(thirdParty.getId()),any(CreateThirdPartyDto.class))).thenReturn(thirdParty);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/thirdparties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].username").value("name")) ;
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/thirdarty/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/thirdarty")
                .content(objectMapper.writeValueAsString(createThirdPartyDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/thirdarty/1")
                .content(objectMapper.writeValueAsString(createThirdPartyDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/thirdarty/1")
        ).andExpect(status().isNoContent());
    }
}