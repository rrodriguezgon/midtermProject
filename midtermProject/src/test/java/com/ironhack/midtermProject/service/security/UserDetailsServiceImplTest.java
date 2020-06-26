package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.*;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import com.ironhack.midtermProject.security.CustomSecurityUser;
import com.ironhack.midtermProject.service.CheckingAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private AccountHolderRepository accountHolderRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    @MockBean
    private CreditCardAccountRepository creditCardAccountRepository;

    @MockBean
    private StudentCheckingAccountRepository studentCheckingAccountRepository;

    @MockBean
    private CheckingAccountRepository checkingAccountRepository;

    @MockBean
    private TranferRepository tranferRepository;

    @MockBean
    private SavingsAccountRepository savingsAccountRepository;

    private AccountHolder accountHolder;
    private Admin admin;
    private ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("holder","password", "firstname",
                "lastname", LocalDate.now(),new Address(),"");

        accountHolder.setId(1);

        thirdParty = new ThirdParty("third", "password", "hashKey");
        thirdParty.setId(2);

        admin = new Admin("admin","pass");
        admin.setId(3);

        when(accountHolderRepository.findByUsername(accountHolder.getUsername())).thenReturn(accountHolder);
        when(adminRepository.findByUsername(admin.getUsername())).thenReturn(admin);
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
    }

    @Test
    void loadUserByUsernameAdmin() {
        CustomSecurityUser customSecurityUser = new CustomSecurityUser(admin);

        assertEquals(customSecurityUser.getAuthorities(),userDetailsService.loadUserByUsername(admin.getUsername()).getAuthorities());
    }

    @Test
    void loadUserByUsernameHolder() {
        CustomSecurityUser customSecurityUser = new CustomSecurityUser(accountHolder);

        assertEquals(customSecurityUser.getAuthorities(),userDetailsService.loadUserByUsername(accountHolder.getUsername()).getAuthorities());
    }

    @Test
    void loadUserByUsernameThirdParty() {
        CustomSecurityUser customSecurityUser = new CustomSecurityUser(thirdParty);

        assertEquals(customSecurityUser.getAuthorities(),userDetailsService.loadUserByUsername(thirdParty.getUsername()).getAuthorities());
    }

    @Test
    void loadUserByUsernameException() {
        CustomSecurityUser customSecurityUser = new CustomSecurityUser(thirdParty);

        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("no existe"));
    }
}