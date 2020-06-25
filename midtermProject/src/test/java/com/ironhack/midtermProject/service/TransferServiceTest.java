package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.exception.FundsException;
import com.ironhack.midtermProject.exception.SecurityAccessException;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.*;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceTest {

    @Autowired
    private TransferService transferService;

    @MockBean
    private CheckingAccountRepository checkingAccountRepository;

    @MockBean
    private SavingsAccountRepository savingsAccountRepository;

    @MockBean
    private StudentCheckingAccountRepository studentCheckingAccountRepository;

    @MockBean
    private CreditCardAccountRepository creditCardAccountRepository;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    @MockBean
    private TranferRepository transferRepository;

    private Transfer transfer;

    private SavingsAccount savingsAccount;
    private CreditCardAccount creditCardAccount;
    private CheckingAccount checkingAccount;
    private StudentCheckingAccount studentCheckingAccount;

    private AccountHolder accountHolderAdult;
    private AccountHolder accountHolderStudent;
    private Admin admin;
    private ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        transfer = new Transfer(Calendar.getInstance().getTime(), new BigDecimal("0"));

        List<Transfer> list = Collections.singletonList(transfer);

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

        admin = new Admin("admin", "password");
        admin.setId(3);

        thirdParty = new ThirdParty("thirdparty", "password", "hashKey");
        thirdParty.setId(4);

        checkingAccount =
                new CheckingAccount(new Money(new BigDecimal("1000")),
                        "secretKey");
        checkingAccount.setId(1);
        checkingAccount.setPrimaryOwner(accountHolderAdult);
        checkingAccount.setSecondaryOwner(accountHolderStudent);

        studentCheckingAccount =
                new StudentCheckingAccount(new Money(new BigDecimal("1000")),
                        "secretKey");
        studentCheckingAccount.setId(2);
        studentCheckingAccount.setPrimaryOwner(accountHolderStudent);
        studentCheckingAccount.setSecondaryOwner(accountHolderAdult);

        creditCardAccount = new CreditCardAccount(new BigDecimal("1"),
                new BigDecimal("1"), new Money(new BigDecimal("1000")));

        creditCardAccount.setId(3);
        creditCardAccount.setPrimaryOwner(accountHolderStudent);
        creditCardAccount.setSecondaryOwner(accountHolderAdult);

        savingsAccount = new SavingsAccount(new Money(new BigDecimal("1000")),
                "secretKey", new BigDecimal("0"));
        savingsAccount.setId(4);
        savingsAccount.setPrimaryOwner(accountHolderAdult);
        savingsAccount.setSecondaryOwner(accountHolderStudent);

        when(transferRepository.findAll()).thenReturn(list);
        when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);

        when(savingsAccountRepository.findById(savingsAccount.getId())).thenReturn(java.util.Optional.ofNullable(savingsAccount));
        when(creditCardAccountRepository.findById(creditCardAccount.getId())).thenReturn(java.util.Optional.ofNullable(creditCardAccount));
        when(checkingAccountRepository.findById(checkingAccount.getId())).thenReturn(java.util.Optional.ofNullable(checkingAccount));
        when(studentCheckingAccountRepository.findById(studentCheckingAccount.getId())).thenReturn(java.util.Optional.ofNullable(studentCheckingAccount));


        when(creditCardAccountRepository.save(any(CreditCardAccount.class))).thenReturn(creditCardAccount);
        when(savingsAccountRepository.save(any(SavingsAccount.class))).thenReturn(savingsAccount);
        when(checkingAccountRepository.save(any(CheckingAccount.class))).thenReturn(checkingAccount);
        when(studentCheckingAccountRepository.save(any(StudentCheckingAccount.class))).thenReturn(studentCheckingAccount);

        when(accountHolderRepository.findByUsername(accountHolderAdult.getUsername())).thenReturn(accountHolderAdult);
        when(accountHolderRepository.findByUsername(accountHolderStudent.getUsername())).thenReturn(accountHolderStudent);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
    }

    @Test
    void findAll() {
        int size = 1;

        assertEquals(size, transferService.findAll().size());
    }

    @Test
    void findAlllByUserId() {
        int size = 1;

        assertEquals(size, transferService.findAlllByUserId(1).size());
    }

    @Test
    void createTransferOK() {
        CreateTransferDto  createTransferDto =
                new CreateTransferDto(1, 2, "Raquel Rodriguez",
                        new BigDecimal("100"));

        assertEquals(transfer,transferService.createTransfer(admin,createTransferDto));
    }

    @Test
    void createTransferInvalidUserSecurityAccessException() {
        CreateTransferDto  createTransferDto =
                new CreateTransferDto(1, 2, "Raquel Rodriguez",
                        new BigDecimal("100"));

        assertThrows(SecurityAccessException.class,() -> transferService.createTransfer(thirdParty,createTransferDto));
    }

    @Test
    void createTransferFoundsException() {
        checkingAccount.getBalance().decreaseAmount(new BigDecimal("1000"));

        CreateTransferDto  createTransferDto =
                new CreateTransferDto(1, 2, "Raquel Rodriguez",
                        new BigDecimal("100"));

        assertThrows(FundsException.class,() ->transferService.createTransfer(admin,createTransferDto));
    }

    @Test
    void createTransaction() {
    }
}