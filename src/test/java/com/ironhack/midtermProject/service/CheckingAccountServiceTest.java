package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.entities.CheckingAccount;
import com.ironhack.midtermProject.model.entities.Money;
import com.ironhack.midtermProject.model.entities.StudentCheckingAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.CheckingAccountRepository;
import com.ironhack.midtermProject.repository.StudentCheckingAccountRepository;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CheckingAccountServiceTest {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @MockBean
    private CheckingAccountRepository checkingAccountRepository;

    @MockBean
    private StudentCheckingAccountRepository studentCheckingAccountRepository;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    private StudentCheckingAccount studentCheckingAccount;

    private CheckingAccount checkingAccount;

    private AccountHolder accountHolderAdult;

    private AccountHolder accountHolderStudent;

    private Admin admin;

    private ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        Address address = new Address();

        accountHolderAdult =
                new AccountHolder("name", "password",
                        "Raquel","Rodriguez",
                        LocalDate.parse("1992-02-15"),
                        address, "mailingAddress");
        accountHolderAdult.setId(1);

        checkingAccount =
                new CheckingAccount(new Money(new BigDecimal("1000")),
                "secretKey");

        checkingAccount.setId(1);
        checkingAccount.setPrimaryOwner(accountHolderAdult);

        List<CheckingAccount> checkingAccountList = Collections.singletonList(checkingAccount);

        accountHolderStudent =
                new AccountHolder("name", "password",
                        "Cristina","Ramirez",LocalDate.parse("1999-10-15"),
                        address, "mailingAddress");
        accountHolderStudent.setId(2);

        studentCheckingAccount =
                new StudentCheckingAccount(new Money(new BigDecimal("1000")),
                        "secretKey");

        studentCheckingAccount.setId(2);
        studentCheckingAccount.setPrimaryOwner(accountHolderStudent);
        studentCheckingAccount.setSecondaryOwner(accountHolderAdult);

        thirdParty = new ThirdParty("third", "password", "hashKey");
        thirdParty.setId(3);

        admin = new Admin("admin","pass");
        admin.setId(4);

        List<StudentCheckingAccount> studentCheckingAccountList = Collections.singletonList(studentCheckingAccount);

        when(checkingAccountRepository.findAll()).thenReturn(checkingAccountList);
        when(studentCheckingAccountRepository.findAll()).thenReturn(studentCheckingAccountList);

        when(checkingAccountRepository.findById(checkingAccount.getId())).thenReturn(java.util.Optional.ofNullable(checkingAccount));
        when(studentCheckingAccountRepository.findById(studentCheckingAccount.getId())).thenReturn(java.util.Optional.ofNullable(studentCheckingAccount));

        when(accountHolderRepository.findById(accountHolderAdult.getId())).thenReturn(java.util.Optional.ofNullable(accountHolderAdult));
        when(accountHolderRepository.findById(accountHolderStudent.getId())).thenReturn(java.util.Optional.ofNullable(accountHolderStudent));
        when(checkingAccountRepository.save(any(CheckingAccount.class))).thenReturn(checkingAccount);
        when(studentCheckingAccountRepository.save(any(StudentCheckingAccount.class))).thenReturn(studentCheckingAccount);

        when(accountHolderRepository.findByUsername(accountHolderAdult.getUsername())).thenReturn(accountHolderAdult);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
    }

    @Test
    void findAll() {
        Integer count = 2;

        assertEquals(count, checkingAccountService.findAll().size());
    }

    @Test
    void createCheckingAccount() {
        CreateCheckingAccountDto checkingAccountdto = new CreateCheckingAccountDto(new BigDecimal("100"),
                "secretKey",
                accountHolderAdult.getId(),accountHolderStudent.getId());

        Account checkingAccount = checkingAccountService.Create(checkingAccountdto);

        assertTrue(checkingAccount instanceof CheckingAccount);
    }

    @Test
    void createStudentCheckingAccount() {
        CreateCheckingAccountDto checkingAccountdto = new CreateCheckingAccountDto(new BigDecimal("100"),
                "secretKey",
                accountHolderStudent.getId(),accountHolderAdult.getId());

        Account studentCheckingAccount = checkingAccountService.Create(checkingAccountdto);

        assertTrue(studentCheckingAccount instanceof StudentCheckingAccount);
    }

    @Test
    void getByIdCheckingAccountAdminUser() {
        Account account = checkingAccountService.findById(admin,checkingAccount.getId());

        assertTrue(account instanceof CheckingAccount);
    }

    @Test
    void getByIdStudentCheckingAccountAdminUser() {
        Account account = checkingAccountService.findById(admin,studentCheckingAccount.getId());

        assertTrue(account instanceof StudentCheckingAccount);
    }

    @Test
    void getByIdCheckingAccountOwnerUser() {
        Account account = checkingAccountService.findById(accountHolderAdult,checkingAccount.getId());

        assertTrue(account instanceof CheckingAccount);
    }

    @Test
    void getByIdStudentCheckingAccountOwnerUser() {
        Account account = checkingAccountService.findById(accountHolderAdult,studentCheckingAccount.getId());

        assertTrue(account instanceof StudentCheckingAccount);
    }

    @Test
    void getByIdCheckingAccountInvalidUser() {
        assertThrows( SecurityAccessException.class, () -> checkingAccountService.findById(thirdParty,checkingAccount.getId()));
    }

    @Test
    void getByIdStudentCheckingAccountInvalidUser() {
        studentCheckingAccount.setSecondaryOwner(null);
        assertThrows( SecurityAccessException.class, () -> checkingAccountService.findById(accountHolderAdult,studentCheckingAccount.getId()));
    }

    @Test
    void getByInvalidIdCheckingAccountAdminUser() {
        Admin user = new Admin();

        assertThrows(DataNotFoundException.class, () -> checkingAccountService.findById(user,3));
    }
}