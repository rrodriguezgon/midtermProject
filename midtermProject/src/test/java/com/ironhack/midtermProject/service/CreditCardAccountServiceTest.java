package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.CreditCardAccountRepository;
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
class CreditCardAccountServiceTest {

    @Autowired
    private CreditCardAccountService creditCardAccountService;

    @MockBean
    private CreditCardAccountRepository creditCardAccountRepository;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    private CreditCardAccount creditCardAccount;

    private CreditCardAccount creditCardAccount2;

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

        creditCardAccount = new CreditCardAccount(new BigDecimal("1000"),
                null, new Money(new BigDecimal("1000")));

        creditCardAccount.setPrimaryOwner(accountHolderAdult);
        creditCardAccount.setSecondaryOwner(accountHolderStudent);
        creditCardAccount.setUpdatedAt(LocalDate.parse("2018-01-01"));

        List<CreditCardAccount> list = Collections.singletonList(creditCardAccount);

        creditCardAccount.setId(1);
        when(creditCardAccountRepository.findAll()).thenReturn(list);
        when(creditCardAccountRepository.findById(creditCardAccount.getId())).thenReturn(java.util.Optional.ofNullable(creditCardAccount));
        when(creditCardAccountRepository.save(any(CreditCardAccount.class))).thenReturn(creditCardAccount);

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

        assertEquals(size, creditCardAccountService.findAll().size());
    }

    @Test
    void create() {
        CreateCreditCardAccountDto createCreditCardAccountDto = new CreateCreditCardAccountDto(new BigDecimal("1"),new BigDecimal("1"), new BigDecimal("1"),
                1,2);

        assertEquals(creditCardAccount.getCreditLimit(),creditCardAccountService.Create(createCreditCardAccountDto).getCreditLimit());
    }

    @Test
    void getByIdAdult() {
        Account account = creditCardAccountService.getById(accountHolderAdult,creditCardAccount.getId());

        assertTrue(account instanceof CreditCardAccount);
    }

    @Test
    void getByIdStudent() {
        Account account = creditCardAccountService.getById(accountHolderStudent,creditCardAccount.getId());

        assertTrue(account instanceof CreditCardAccount);
    }

    @Test
    void getByIdAdmin() {
        Account account = creditCardAccountService.getById(admin,creditCardAccount.getId());

        assertTrue(account instanceof CreditCardAccount);
    }

    @Test
    void getByIdInvalidUser() {
        assertThrows( SecurityAccessException.class, () -> creditCardAccountService.getById(thirdParty,creditCardAccount.getId()));
    }
}