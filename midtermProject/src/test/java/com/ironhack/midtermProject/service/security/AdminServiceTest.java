package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private AdminRepository adminRepository;

    private Admin admin;
    private Admin admin2;

    @BeforeEach
    void setUp() {

        admin = new Admin("user","pass");
        admin.setId(1);

        admin2 = new Admin("admin","pass");

        List<Admin> list = Collections.singletonList(admin);

        when(adminRepository.findAll()).thenReturn(list);
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);
        when(adminRepository.findById(admin.getId())).thenReturn(java.util.Optional.ofNullable(admin));
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
        when(adminRepository.findByUsername(admin2.getUsername())).thenReturn(admin2);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
    }

    @Test
    void findAll() {
        int size = 1;

        assertEquals(size,adminService.findAll().size());
    }

    @Test
    void create() {
        CreateAdminDto createAdminDto =
                new CreateAdminDto("username","password");

        assertEquals(admin.getPassword(),
                adminService.Create(createAdminDto).getPassword());
    }

    @Test
    void createThrows() {
        CreateAdminDto createAdminDto =
                new CreateAdminDto("user","password");

        assertThrows(UserExistException.class,() ->
                adminService.Create(createAdminDto));
    }

    @Test
    void findById() {
        assertEquals(admin.getPassword(),adminService.findById(admin.getId()).getPassword());
    }

    @Test
    void update() {
        Integer id = 1;
        CreateAdminDto createAdminDto =
                new CreateAdminDto("user","password");

        assertEquals(admin.getUsername(),adminService.update(id,createAdminDto).getUsername());
    }

    @Test
    void deleteById() {
        Integer id = 1;

        adminService.deleteById(id);
    }
}