package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.model.entities.Money;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.CreditCardAccountRepository;
import com.ironhack.midtermProject.repository.SavingsAccountRepository;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class SavingAccountServiceTest {

    @Autowired
    private SavingAccountService savingAccountService;

    @MockBean
    private SavingsAccountRepository savingsAccountRepository;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    private SavingsAccount savingsAccount;

    private AccountHolder accountHolderAdult;

    private AccountHolder accountHolderStudent;

    private Admin admin;

    private ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        Address address = new Address();

        accountHolderAdult =
                new AccountHolder("adult", "password",
                        "Raquel","Rodriguez",
                        LocalDate.parse("1992-02-15"),
                        address, "mailingAddress");
        accountHolderAdult.setId(1);

        accountHolderStudent =
                new AccountHolder("student", "password",
                        "Cristina","Ramirez",LocalDate.parse("1999-10-15"),
                        address, "mailingAddress");
        accountHolderStudent.setId(2);

        thirdParty = new ThirdParty("third", "password", "hashKey");
        thirdParty.setId(3);

        admin = new Admin("admin","pass");
        admin.setId(4);

        savingsAccount = new SavingsAccount(new Money(new BigDecimal("1000")),
                "secretKey",null);

        savingsAccount.setPrimaryOwner(accountHolderAdult);
        savingsAccount.setSecondaryOwner(accountHolderStudent);
        savingsAccount.setUpdatedAt(LocalDate.parse("2018-01-01"));

        List<SavingsAccount> list = Collections.singletonList(savingsAccount);

        savingsAccount.setId(1);
        when(savingsAccountRepository.findAll()).thenReturn(list);
        when(savingsAccountRepository.findById(savingsAccount.getId())).thenReturn(java.util.Optional.ofNullable(savingsAccount));
        when(savingsAccountRepository.save(any(SavingsAccount.class))).thenReturn(savingsAccount);

        when(accountHolderRepository.findById(accountHolderAdult.getId())).thenReturn(java.util.Optional.ofNullable(accountHolderAdult));
        when(accountHolderRepository.findById(accountHolderStudent.getId())).thenReturn(java.util.Optional.ofNullable(accountHolderStudent));
        when(accountHolderRepository.findByUsername(accountHolderAdult.getUsername())).thenReturn(accountHolderAdult);
        when(accountHolderRepository.findByUsername(accountHolderStudent.getUsername())).thenReturn(accountHolderStudent);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
    }

    @Test
    void findAll() {
        int size = 1;

        assertEquals(size, savingAccountService.findAll().size());
    }

    @Test
    void create() {
        CreateSavingAccountDto createSavingAccountDto =
                new CreateSavingAccountDto(new BigDecimal("1"),new BigDecimal("1"), "secretKey"
                        ,1,2);

        assertEquals(savingsAccount.getMIN_RATE(),savingAccountService.Create(createSavingAccountDto).getMIN_RATE());
    }

    @Test
    void getByIdAdult() {
        Account account = savingAccountService.getById(accountHolderAdult,accountHolderAdult.getId());

        assertTrue(account instanceof SavingsAccount);
    }

    @Test
    void getByIdStudent() {
        Account account = savingAccountService.getById(accountHolderStudent,accountHolderAdult.getId());

        assertTrue(account instanceof SavingsAccount);
    }

    @Test
    void getByIdAdmin() {
        Account account = savingAccountService.getById(admin,accountHolderAdult.getId());

        assertTrue(account instanceof SavingsAccount);
    }

    @Test
    void getByIdInvalidUser() {
        assertThrows( SecurityAccessException.class, () -> savingAccountService.getById(thirdParty,accountHolderAdult.getId()));
    }

}