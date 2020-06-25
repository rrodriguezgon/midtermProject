package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.entities.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.*;
import com.ironhack.midtermProject.repository.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private StudentCheckingAccountRepository studentCheckingAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    public List<Account> findAll(){
        List<CheckingAccount> checkingAccounts = checkingAccountRepository.findAll();
        List<StudentCheckingAccount> studentCheckingAccounts  = studentCheckingAccountRepository.findAll();

        List<Account> listAccount = new ArrayList<Account>(checkingAccounts);
        listAccount.addAll(studentCheckingAccounts);

        return listAccount;
    }

    public Account Create(CreateCheckingAccountDto checkingAccountdto){
        AccountHolder primaryOwner = null;
        AccountHolder secondaryOwner = null;

        if (checkingAccountdto.getPrimaryOwnerId() != null){
            primaryOwner = accountHolderRepository.findById(checkingAccountdto.getPrimaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        if (checkingAccountdto.getSecondaryOwnerId() != null){
            secondaryOwner = accountHolderRepository.findById(checkingAccountdto.getSecondaryOwnerId()).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        if (calcular(primaryOwner.getBirthday()) < 24){
            StudentCheckingAccount studentCheckingAccount =
                    new StudentCheckingAccount(new Money(checkingAccountdto.getBalance()),
                            checkingAccountdto.getSecretKey());

            addOwners(studentCheckingAccount,primaryOwner,secondaryOwner);

            return studentCheckingAccountRepository.save(studentCheckingAccount);
        } else {

            CheckingAccount checkingAccountNew =
                    new CheckingAccount(new Money(checkingAccountdto.getBalance()),
                            checkingAccountdto.getSecretKey());

            addOwners(checkingAccountNew,primaryOwner,secondaryOwner);

            return checkingAccountRepository.save(checkingAccountNew);
        }
    }

    public Account findById(User userLogin, Integer id){
        User user = parseUser(userLogin);
        Account account = null;

        Optional<CheckingAccount> accountFoud = checkingAccountRepository.findById(id);

        if (accountFoud.isPresent()){
            account = accountFoud.get();
        } else {
            account = studentCheckingAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("This id AccountHolder not exist."));
        }

        if (!checkPermissions(account, user)){
            throw new SecurityAccessException("This user not have permission about this Account");
        }

        return account;
    }

    private int calcular(LocalDate fechaNacDate) {
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
        return years;
    }

    private void addOwners(Account account, AccountHolder primaryOwner, AccountHolder secondaryOwner){

        if (primaryOwner != null){
            account.setPrimaryOwner(primaryOwner);
        }

        if (secondaryOwner != null){
            account.setSecondaryOwner(secondaryOwner);
        }
    }

    private Boolean checkPermissions(Account account, User user) {
        if ((user instanceof Admin) == false){
            Boolean checked = false;

            User primaryuserAccount = account.getPrimaryOwner();
            User seconduserAccount = account.getSecondaryOwner();

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
}