package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.entities.CheckingAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountHolderServiceTest {

    @Autowired
    private AccountHolderService accountHolderService;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    private AccountHolder accountHolder;
    private AccountHolder accountHolder2;
    private Admin admin;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("user","password", "firstname",
                "lastname", LocalDate.now(),new Address(),"");

        accountHolder2 = new AccountHolder("user2","password", "firstname",
                "lastname", LocalDate.now(),new Address(),"");

        accountHolder.setId(1);
        accountHolder2.setId(2);

        admin = new Admin("user","pass");

        List<AccountHolder> list = Collections.singletonList(accountHolder);

        when(accountHolderRepository.findAll()).thenReturn(list);
        when(accountHolderRepository.save(any(AccountHolder.class))).thenReturn(accountHolder);
        when(accountHolderRepository.findById(accountHolder.getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));
        when(accountHolderRepository.findByUsername(accountHolder.getUsername())).thenReturn(accountHolder);
        when(accountHolderRepository.findByUsername(accountHolder2.getUsername())).thenReturn(accountHolder2);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
    }

    @Test
    void findAll() {
        int size = 1;

        assertEquals(size,accountHolderService.findAll().size());
    }

    @Test
    void create() {
        CreateAccountHolderDto createAccountHolderDto =
                new CreateAccountHolderDto("username", "password", "firstName", "lastName",
                        LocalDate.now(), new Address(), "mailingAddress");

        assertEquals(accountHolder.getBirthday(),
                accountHolderService.Create(createAccountHolderDto).getBirthday());
    }

    @Test
    void createThrows() {
        CreateAccountHolderDto createAccountHolderDto =
                new CreateAccountHolderDto("user", "password", "firstName", "lastName",
                        LocalDate.now(), new Address(), "mailingAddress");

        assertThrows(UserExistException.class,() ->
                accountHolderService.Create(createAccountHolderDto));
    }

    @Test
    void findById() {
        assertEquals(accountHolder.getBirthday(),accountHolderService.findById(admin,accountHolder.getId()).getBirthday());
    }

    @Test
    void findByIdSecurityException() {
        assertThrows(SecurityAccessException.class,() -> accountHolderService.findById(accountHolder2,accountHolder.getId()).getBirthday());
    }

    @Test
    void update() {
        Integer id = 1;
        UpdateAccountHolderDto updateAccountHolderDto =
                new UpdateAccountHolderDto("firstName", "lastName",
                        LocalDate.now(), new Address(), "mailingAddress");

        assertEquals(accountHolder.getBirthday(),accountHolderService.update(admin,id,updateAccountHolderDto).getBirthday());
    }

    @Test
    void deleteById() {
        Integer id = 1;

        accountHolderService.deleteById(admin,id);
    }
}