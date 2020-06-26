package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.*;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.*;
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
import java.util.Optional;

@Service
public class TransferService {

    private static final Logger LOGGER = LogManager.getLogger(TransferService.class);

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Autowired
    private StudentCheckingAccountRepository studentCheckingAccountRepository;

    @Autowired
    private CreditCardAccountRepository creditCardAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private TranferRepository transferRepository;

    public List<Transfer> findAll(){
        return transferRepository.findAll();
    }

    // MODIFICAR PARA FILTRAR POR USUARIO.
    public List<Transfer> findAlllByUserId(Integer id){
        return transferRepository.findAll();
    }

    public Transfer createTransfer(User userLogin, CreateTransferDto createTransferDto){
        User user = parseUser(userLogin);
        Account accountEmitter = getAccount(createTransferDto.getEmitterAccountId());
        Account accountReceiver = getAccount(createTransferDto.getReceiverAccountId());

        checkInterestRate(accountEmitter);

        checkPermissionsTransfer(accountEmitter, accountReceiver, user, createTransferDto.getReceiverAccountName());

        checkFraud(accountEmitter);

        BigDecimal calcAmount = accountEmitter.getBalance().getAmount().subtract(createTransferDto.getAmount());

        if (calcAmount.signum() == -1){
            FundsException ex = new FundsException("Insufficient funds");
            LOGGER.error("Account Emitter Id: " + accountEmitter.getId() + " - Account balance: " + accountEmitter.getBalance().getAmount() + " - Import Transfer: " + createTransferDto.getAmount(),ex);
            throw ex;
        }

        accountEmitter.getBalance().decreaseAmount(createTransferDto.getAmount());
        accountReceiver.getBalance().increaseAmount(createTransferDto.getAmount());

        checkPenalityAccount(accountEmitter);

        saveAccount(accountEmitter);
        saveAccount(accountReceiver);

        Transfer transfer = new Transfer(Calendar.getInstance().getTime(),createTransferDto.getAmount());
        transfer.setEmitteraccount(accountEmitter);
        transfer.setReceiverAccount(accountReceiver);
        transfer.setEmitterUser(user);

        return transferRepository.save(transfer);
    }

    public Transfer createTransaction(User userLogin, CreateTransactionDto createTransactionDto, String hashKey){
        User user = parseUser(userLogin);

        Account account = getAccount(createTransactionDto.getAccountId());

        checkInterestRate(account);

        if (user instanceof ThirdParty){
            checkPermissionsTransaction((ThirdParty) user, createTransactionDto, hashKey, account);
        }

        checkFraud(account);

        Transfer transfer = new Transfer(Calendar.getInstance().getTime(), createTransactionDto.getAmount());
        transfer.setEmitterUser(user);

        switch (createTransactionDto.getTypeTransaction()){
            case CREDIT:
                account.getBalance().increaseAmount(createTransactionDto.getAmount());
                transfer.setReceiverAccount(account);
                break;
            case DEBIT:
                account.getBalance().decreaseAmount(createTransactionDto.getAmount());
                transfer.setEmitteraccount(account);
                break;
        }

        saveAccount(account);

        return transferRepository.save(transfer);
    }

    private void checkPermissionsTransaction(ThirdParty user, CreateTransactionDto createTransactionDto, String hashKey, Account account) {
        Boolean checked = false;
        String secretKeyAccount = "";

        checked = user.getHashKey().equals(hashKey);

        if (!checked){
            SecurityAccessException ex = new SecurityAccessException("This haskey not is valid.");
            LOGGER.error("ThirdParty user Id: " + user.getId() + " - Param hashKey: " + hashKey + " - ThirdParty hashKey: " + user.getHashKey(),ex);
            throw ex;
        }

        if (account instanceof AccountKey) {
            if (checked && account instanceof StudentCheckingAccount) {
                secretKeyAccount = ((StudentCheckingAccount) account).getSecretKey();
                checked = secretKeyAccount.equals(createTransactionDto.getSecretKey())
                        && ((StudentCheckingAccount) account).getStatus() == StatusAccount.ACTIVE;
            } else if (checked && account instanceof SavingsAccount) {
                secretKeyAccount = ((SavingsAccount) account).getSecretKey();
                checked = secretKeyAccount.equals(createTransactionDto.getSecretKey())
                        && ((SavingsAccount) account).getStatus() == StatusAccount.ACTIVE;
            } else if (checked && account instanceof CheckingAccount) {
                secretKeyAccount = ((CheckingAccount) account).getSecretKey();
                checked = secretKeyAccount.equals(createTransactionDto.getSecretKey())
                        && ((CheckingAccount) account).getStatus() == StatusAccount.ACTIVE;
            }
        }

        if (!checked){
            SecurityAccessException ex = new SecurityAccessException("This secretKey receiver not is valid.");
            LOGGER.error("ThirdParty user Id: " + user.getId() + " - Param secretKey: " + createTransactionDto.getSecretKey() + " - Account secretKey: " + secretKeyAccount,ex);
            throw ex;
        }
    }

    private Account getAccount(Integer accountId) {
        Account account = null;

        Optional<SavingsAccount> savingsAccount = savingsAccountRepository.findById(accountId);
        if (!savingsAccount.isPresent()){
            Optional<CheckingAccount> checkingAccount = checkingAccountRepository.findById(accountId);
            if (!checkingAccount.isPresent()){
                Optional<StudentCheckingAccount> studentCheckingAccount =  studentCheckingAccountRepository.findById(accountId);
                if (!studentCheckingAccount.isPresent()){
                    CreditCardAccount creditCardAccount = creditCardAccountRepository.findById(accountId).orElseThrow(() -> new DataNotFoundException("this Account id not exists."));

                    return creditCardAccount;
                }
                return studentCheckingAccount.get();
            }
            return checkingAccount.get();
        } else {
            return savingsAccount.get();
        }
    }

    private void saveAccount(Account account){
        if (account instanceof SavingsAccount){
            savingsAccountRepository.save((SavingsAccount)account);
        }

        if (account instanceof CheckingAccount){
            checkingAccountRepository.save((CheckingAccount)account);
        }

        if (account instanceof StudentCheckingAccount){
            studentCheckingAccountRepository.save((StudentCheckingAccount)account);
        }

        if (account instanceof CreditCardAccount){
            creditCardAccountRepository.save((CreditCardAccount)account);
        }
    }

    private void checkPermissionsTransfer(Account accountEmitter, Account accountReceiver, User user, String accountReceiverName) {
        Boolean check = false;

        User userPrimaryuserAccount = null;
        User userSeconduserAccount = null;

        // region checkEmmiter
        if ((user instanceof Admin) == false) {
            userPrimaryuserAccount = accountEmitter.getPrimaryOwner();
            userSeconduserAccount = accountEmitter.getSecondaryOwner();

            if (userPrimaryuserAccount != null){
                check = user.getId() == userPrimaryuserAccount.getId();
            }

            if (!check && userSeconduserAccount != null){
                check = user.getId() == userSeconduserAccount.getId();
            }
        } else {
            check = true;
        }

        if (!check){
            SecurityAccessException ex = new SecurityAccessException("This user not have permission about this Account");
            LOGGER.error("user Id: " + user.getId()
                    + ((userPrimaryuserAccount != null) ? " - userPrimaryuserAccount Id: " + userPrimaryuserAccount.getId() : "")
                    + ((userSeconduserAccount != null) ? " - userSeconduserAccount Id: " + userSeconduserAccount.getId() : ""));
            throw ex;
        }
        // endregion

        check = false;

        // region checkReceiver

        AccountHolder primaryuserAccount = (AccountHolder) accountReceiver.getPrimaryOwner();
        AccountHolder seconduserAccount = (AccountHolder) accountReceiver.getSecondaryOwner();

        if (primaryuserAccount != null){
            check = accountReceiverName.equals(primaryuserAccount.getFirstAndLastnName());
        }

        if (!check && seconduserAccount != null){
            check = accountReceiverName.equals(seconduserAccount.getFirstAndLastnName());
        }

        if (!check){
            SecurityAccessException ex = new SecurityAccessException("This name receiver not is equals to name AccountReceiver.");
            LOGGER.error("Account Receiver Name: " + accountReceiverName
                    + ((primaryuserAccount != null) ? " - primaryuserAccount Name: " + primaryuserAccount.getFirstAndLastnName() : "")
                    + ((seconduserAccount != null) ? " - seconduserAccount Name: " + seconduserAccount.getFirstAndLastnName() : ""));

            throw ex;
        }
        // endregion

        check = false;

        // region checkStatusAccount

        if (accountEmitter instanceof AccountKey) {
            if (accountEmitter instanceof StudentCheckingAccount) {
                check = ((StudentCheckingAccount) accountEmitter).getStatus() == StatusAccount.ACTIVE;
            } else if (accountEmitter instanceof SavingsAccount) {
                check = ((SavingsAccount) accountEmitter).getStatus() == StatusAccount.ACTIVE;
            } else if (accountEmitter instanceof CheckingAccount) {
                check = ((CheckingAccount) accountEmitter).getStatus() == StatusAccount.ACTIVE;
            }
        } else {
            check = true;
        }

        if (!check){
            throw new SecurityAccessException("This Account emitter is Status Frozen.");
        }
        //endregion
    }

    private void checkPenalityAccount(Account account){
        if (account instanceof CheckingAccount
                && (account.getBalance().getAmount().compareTo(((CheckingAccount) account)
                .getMinimumBalance()) == -1)){

                account.getBalance().decreaseAmount(account.getPenaltyFee());
        }

        if (account instanceof SavingsAccount
                && (account.getBalance().getAmount().compareTo(((SavingsAccount) account)
                .getMinimumBalance()) == -1)){

            account.getBalance().decreaseAmount(account.getPenaltyFee());
        }

        if (account instanceof CreditCardAccount
                && (account.getBalance().getAmount().compareTo(((CreditCardAccount) account)
                .getCreditLimit()) == -1)){

            account.getBalance().decreaseAmount(account.getPenaltyFee());
        }
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

    private void checkInterestRate(Account account){
        if (account instanceof SavingsAccount){
            calcularInteresXAño(calcularXAño(account.getUpdatedAt()),(SavingsAccount) account);
        }

        if (account instanceof CreditCardAccount){
            calcularInteresXMes(calcularXMes(account.getUpdatedAt()),(CreditCardAccount) account);
        }
    }

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

        if(months < 0 // Aún no es el mes de su cumpleaños
                || (months==0 && days < 0)) { // o es el mes pero no ha llegado el día.
            years--;
        }
        return new int[] {months, days};
    }

    private void calcularInteresXMes(int[] calcTime, CreditCardAccount savingsAccount){

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

        if(months < 0 // Aún no es el mes de su cumpleaños
                || (months==0 && days < 0)) { // o es el mes pero no ha llegado el día.
            years--;
        }
        return new int[] {years, months};
    }

    private void calcularInteresXAño(int[] calcTime, SavingsAccount savingsAccount){

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

    private void checkFraud(Account account){
        double maxTransactionsAccount = getMaxTransactionsAccount(account.getId()) * 1.5;
        Integer numberTransactionsAccountDay = getNumberTransactionsAccountDay(account.getId());
        Integer numberTransactionsAccountSecond = getNumberTransactionsAccountSecond(account.getId());
        if (numberTransactionsAccountDay > maxTransactionsAccount){
            if(account instanceof AccountKey){
                ((AccountKey)account).setStatus(StatusAccount.FROZEN);
            }

            FraudException ex = new FraudException("Your number Transactions of day is greater than normal transactions");
            LOGGER.error("numberTransactionsAccountDay " + numberTransactionsAccountDay + " - maxTransactionsAccount " + maxTransactionsAccount,ex);
            throw ex;
        }

        if (numberTransactionsAccountSecond != null && numberTransactionsAccountSecond == 2){
            if(account instanceof AccountKey){
                ((AccountKey)account).setStatus(StatusAccount.FROZEN);
            }

            FraudException ex = new FraudException("Your number Transactions of second is greater than normal transactions");
            LOGGER.error("numberTransactionsAccountSecond " + numberTransactionsAccountSecond,ex);
            throw ex;
        }
    }

    private Integer getMaxTransactionsAccount(Integer accountId){
        return transferRepository.getMaxTransactionsAccount(accountId);
    }

    private Integer getNumberTransactionsAccountDay(Integer accountId){
        return transferRepository.getNumberTransactionsAccountDay(accountId);
    }

    private Integer getNumberTransactionsAccountSecond(Integer accountId){
        return transferRepository.getNumberTransactionsAccountSecond(accountId);
    }
}