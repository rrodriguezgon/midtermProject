package com.ironhack.midtermProject.repository;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.entities.CheckingAccount;
import com.ironhack.midtermProject.model.entities.Money;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Address;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CheckingAccountRepositoryTest {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    private CheckingAccount checkingAccount;
    private AccountHolder accountHolder;
    private ThirdParty thirdParty;

    @BeforeEach
    public void setUp(){
        Address address = new Address("number","street","city","country");

        /*
        accountHolder = new AccountHolder("Raquel","password",
                null, address, "email@address.com");
*/
        accountHolderRepository.save(accountHolder);

        thirdParty = new ThirdParty("Nombre", "password","hashkey");

        thirdPartyRepository.save(thirdParty);

        checkingAccount = new CheckingAccount(new Money(new BigDecimal("100")),"secretKey");

        checkingAccount = checkingAccountRepository.save(checkingAccount);
    }

    /*
    @Test
    public void save(){
        CheckingAccount checkingAccountNew = new CheckingAccount(new Money(new BigDecimal("1000")),"secretKey");

        checkingAccountNew.setPrimaryOwner(accountHolder);
        checkingAccountNew.setSecondaryOwner(thirdParty);

        CheckingAccount checkingAccountSaved = checkingAccountRepository.save(checkingAccountNew);

        assertEquals(checkingAccountSaved.getMonthlyMaintenanceFee(), checkingAccountNew.getMonthlyMaintenanceFee());
    }
*/
    public void findById(){

    }
}