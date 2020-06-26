package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.SavingsAccountRepository;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class SavingAccountService {

    private static final Logger LOGGER = LogManager.getLogger(SavingAccountService.class);

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    public List<SavingsAccount> findAll(){
        return savingsAccountRepository.findAll();
    }

    public SavingsAccount Create(CreateSavingAccountDto createSavingAccountDto){
        AccountHolder primaryOwner = null;
        AccountHolder secondaryOwner = null;

        if (createSavingAccountDto.getPrimaryOwnerId() != null){
            primaryOwner = accountHolderRepository.findById(createSavingAccountDto.getPrimaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        if (createSavingAccountDto.getSecondaryOwnerId() != null){
            secondaryOwner = accountHolderRepository.findById(createSavingAccountDto.getSecondaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        SavingsAccount savingsAccount = new SavingsAccount(new Money(createSavingAccountDto.getBalance()),
                createSavingAccountDto.getSecretKey(),
                createSavingAccountDto.getInterestRate());

        addOwners(savingsAccount,primaryOwner,secondaryOwner);

        return savingsAccountRepository.save(savingsAccount);
    }

    public SavingsAccount getById(User userLogin, Integer id){
        User user = parseUser(userLogin);
        SavingsAccount savingsAccount = savingsAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this savingAccount Id not Found."));

        if (!checkPermissions(savingsAccount, user)){
            SecurityAccessException ex = new SecurityAccessException("This user not have permission about this Account");
            LOGGER.error("user Name: " + user.getUsername(),ex);
            throw ex;
        }

        int[] calcTime = calcularXAño(savingsAccount.getUpdatedAt());
        if (calcTime[0] >= 1){
            calcularInteres(calcTime,savingsAccount);
        }

        return savingsAccount;
    }

    private Boolean checkPermissions(Account account, User user) {
        if ((user instanceof Admin) == false){
            User primaryuserAccount = account.getPrimaryOwner();
            User seconduserAccount = account.getSecondaryOwner();

            Boolean checked = false;

            if (primaryuserAccount != null){
                checked = user.getUsername().equals(primaryuserAccount.getUsername()) &&
                        user.getId() == primaryuserAccount.getId();
            }

            if (!checked && seconduserAccount != null){
                checked = user.getUsername().equals(seconduserAccount.getUsername()) &&
                        user.getId() == seconduserAccount.getId();
            }

            return checked;
        } else {
            return true;
        }
    }

    private int[] calcularXAño(LocalDate fechaNacDate) {
        Calendar fechaActual = Calendar.getInstance();

        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(java.sql.Date.valueOf(fechaNacDate));

        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        // Hay que comprobar si el día de su cumpleaños es posterior
        // a la fecha actual, para restar 1 a la diferencia de años,
        // pues aún no ha sido su cumpleaños.

        return new int[] {years, months};
    }

    private void calcularInteres(int[] calcTime, SavingsAccount savingsAccount){

        int countYears = calcTime[0];
        int countMonths = calcTime[1];

        for (int i = 0; i < countYears; i++){
            Money balance = savingsAccount.getBalance();
            BigDecimal interestRate = savingsAccount.getInterestRate();

            BigDecimal interestCalc = balance.getAmount().multiply(interestRate);
            balance.increaseAmount(interestCalc);
        }

        savingsAccount.setUpdatedAt(LocalDate.now().minusMonths(countMonths));
    }

    private User parseUser(User userLogin){
        User user = adminRepository.findByUsername(userLogin.getUsername());
        if (user == null){
            user = accountHolderRepository.findByUsername(userLogin.getUsername());

            if (user == null){
                user = thirdPartyRepository.findByUsername(userLogin.getUsername());
            }
        }

        return user;
    }

    private void addOwners(Account account, AccountHolder primaryOwner, AccountHolder secondaryOwner){

        if (primaryOwner != null){
            account.setPrimaryOwner(primaryOwner);
        }

        if (secondaryOwner != null){
            account.setSecondaryOwner(secondaryOwner);
        }
    }

}
