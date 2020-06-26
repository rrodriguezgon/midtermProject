/**
 *
 */
package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.CreditCardAccountRepository;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
@Service
public class CreditCardAccountService {

    private static final Logger LOGGER = LogManager.getLogger(CreditCardAccountService.class);

    @Autowired
    private CreditCardAccountRepository creditCardAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    /**
     *
     * @return
     */
    public List<CreditCardAccount> findAll(){
        return creditCardAccountRepository.findAll();
    }

    /**
     *
     * @param createCreditCardAccountDto
     * @return
     */
    public CreditCardAccount Create(CreateCreditCardAccountDto createCreditCardAccountDto){

        AccountHolder primaryOwner = null;
        AccountHolder secondaryOwner = null;

        if (createCreditCardAccountDto.getPrimaryOwnerId() != null){
            primaryOwner = accountHolderRepository.findById(createCreditCardAccountDto.getPrimaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        if (createCreditCardAccountDto.getSecondaryOwnerId() != null){
            secondaryOwner = accountHolderRepository.findById(createCreditCardAccountDto.getSecondaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        CreditCardAccount creditCardAccount = new CreditCardAccount(createCreditCardAccountDto.getCreditLimit(),
                createCreditCardAccountDto.getInterestRate(),
                new Money(createCreditCardAccountDto.getBalance()));

        addOwners(creditCardAccount,primaryOwner,secondaryOwner);

        return creditCardAccountRepository.save(creditCardAccount);
    }

    /**
     *
     * @param userLogin
     * @param id
     * @return
     */
    public CreditCardAccount getById(User userLogin, Integer id){
        User user = parseUser(userLogin);

        CreditCardAccount creditCardAccount = creditCardAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this creditCardAccount Id not Found."));

        if (!checkPermissions(creditCardAccount, user)){
            SecurityAccessException ex = new SecurityAccessException("This user not have permission about this Account");
            LOGGER.error("user Name: " + user.getUsername(),ex);
            throw ex;
        }

        int[] calcTime = calcularXMes(creditCardAccount.getUpdatedAt());
        if (calcTime[0] >= 1){
            calcularInteres(calcTime,creditCardAccount);
        }

        return creditCardAccount;
    }

    /**
     *
     * @param account
     * @param user
     * @return
     */
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

    /**
     *
     * @param fechaNacDate
     * @return
     */
    private int[] calcularXMes(LocalDate fechaNacDate) {
        Calendar fechaActual = Calendar.getInstance();

        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(java.sql.Date.valueOf(fechaNacDate));

        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        months += years * 12;

        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        // Hay que comprobar si el día de su cumpleaños es posterior
        // a la fecha actual, para restar 1 a la diferencia de años,
        // pues aún no ha sido su cumpleaños.

        return new int[] {months, days};
    }

    /**
     *
     * @param calcTime
     * @param savingsAccount
     */
    private void calcularInteres(int[] calcTime, CreditCardAccount savingsAccount){

        int countMonths = calcTime[0];
        int countDays = calcTime[1];

        for (int i = 0; i < countMonths; i++){
            Money balance = savingsAccount.getBalance();
            BigDecimal interestRate = savingsAccount.getInterestRate();

            BigDecimal interestCalc = balance.getAmount().multiply(interestRate);
            balance.increaseAmount(interestCalc);
        }

        savingsAccount.setUpdatedAt(LocalDate.now().minusDays(countDays));
    }

    /**
     *
     * @param userLogin
     * @return
     */
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

    /**
     *
     * @param account
     * @param primaryOwner
     * @param secondaryOwner
     */
    private void addOwners(Account account, AccountHolder primaryOwner, AccountHolder secondaryOwner){

        if (primaryOwner != null){
            account.setPrimaryOwner(primaryOwner);
        }

        if (secondaryOwner != null){
            account.setSecondaryOwner(secondaryOwner);
        }
    }
}
