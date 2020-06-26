/**
 *
 */
package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class AccountHolderService {

    private static final Logger LOGGER = LogManager.getLogger(AccountHolderService.class);

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    /**
     *
     * @return
     */
    public List<AccountHolder> findAll(){
        return accountHolderRepository.findAll();
    }

    /**
     *
     * @param createAccountHolderDto
     * @return
     */
    public AccountHolder Create(CreateAccountHolderDto createAccountHolderDto){
        AccountHolder user = accountHolderRepository.findByUsername(createAccountHolderDto.getUsername());

        if (user != null){
            UserExistException ex = new UserExistException("This user exists.");
            LOGGER.error("username: " + createAccountHolderDto.getUsername(),ex);

            throw ex;
        }

        AccountHolder accountHolder = new AccountHolder(createAccountHolderDto.getUsername(),
                createAccountHolderDto.getPassword(),
                createAccountHolderDto.getFirstName(),
                createAccountHolderDto.getLastName(),
                createAccountHolderDto.getBirthday(),
                createAccountHolderDto.getPrimaryAddress(),
                createAccountHolderDto.getMailingAddress());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));

        HashSet<Role> roles = new HashSet<Role>();
        Role role = new Role("ROLE_HOLDER");
        role.setUser(accountHolder);

        roles.add(role);

        accountHolder.setRoles(roles);

        return accountHolderRepository.save(accountHolder);
    }

    /**
     *
     * @param userLogin
     * @param id
     * @return
     */
    public AccountHolder findById(User userLogin, Integer id){
        User user = parseUser(userLogin);

        if (!checkPermissions(user,id)){
            throw new SecurityAccessException("This user does not have permissions.");
        }

        return accountHolderRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this AccountHolder id not Found."));
    }

    /**
     *
     * @param userLogin
     * @param id
     * @param updateAccountHolderDto
     * @return
     */
    public AccountHolder update(User userLogin, Integer id, UpdateAccountHolderDto updateAccountHolderDto){
        AccountHolder accountHolderFound = findById(userLogin, id);

        accountHolderFound.setBirthday(updateAccountHolderDto.getBirthday());
        accountHolderFound.setFirstName(updateAccountHolderDto.getFirstName());
        accountHolderFound.setLastName(updateAccountHolderDto.getLastName());
        accountHolderFound.setMailingAddress(updateAccountHolderDto.getMailingAddress());
        accountHolderFound.setPrimaryAddress(updateAccountHolderDto.getPrimaryAddress());

        return accountHolderRepository.save(accountHolderFound);
    }

    /**
     *
     * @param userLogin
     * @param id
     */
    public void deleteById(User userLogin, Integer id){
        AccountHolder accountHolder = findById(userLogin, id);

        accountHolderRepository.delete(accountHolder);
    }

    /**
     *
     * @param user
     * @param id
     * @return
     */
    private Boolean checkPermissions(User user, Integer id) {
        if ((user instanceof Admin) == false){
            return user.getId() == id;
        } else {
            return true;
        }
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
        }

        return user;
    }
}