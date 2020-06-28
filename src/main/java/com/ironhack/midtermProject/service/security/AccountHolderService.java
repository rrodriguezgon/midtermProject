/**
 * com.ironhack.midtermProject.service.security
 */
package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.model.viewModel.AccountHolderViewModel;
import com.ironhack.midtermProject.model.viewModel.AccountViewModel;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * AccountHolderService Class.
 */
@Service
public class AccountHolderService {

    private static final Logger LOGGER = LogManager.getLogger(AccountHolderService.class);

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    /**
     * findAll
     * @return List of Account Holder's
     */
    public List<AccountHolderViewModel> findAll(){
        return  accountHolderRepository.findAll().stream().map(holder -> transformHolderToViewModel(holder)).collect(Collectors.toList());
    }

    /**
     *
     * @param holder
     * @return
     */
    private AccountHolderViewModel transformHolderToViewModel(AccountHolder holder) {
        String roles = holder.getRoles().stream().map(rol -> rol.getRole()).collect(joining(","));
        String accountsPrimary = "";
        String accountsSecondary = "";

        if (holder.getAccountsPrimary() != null){
            accountsPrimary = holder.getAccountsPrimary().stream().map(account -> account.getId().toString()).collect(joining(","));
        }

        if (holder.getAccountsSecondary() != null){
            accountsSecondary = holder.getAccountsSecondary().stream().map(account -> account.getId().toString()).collect(joining(","));
        }

        return new AccountHolderViewModel(holder.getId(),
                holder.getUsername(),holder.getPassword(),roles,
                holder.getFirstName(),holder.getLastName(), holder.getBirthday(),
                holder.getPrimaryAddress(),
                accountsPrimary,
                accountsSecondary,
                holder.getMailingAddress());
    }

    /**
     *
     * @param createAccountHolderDto
     * @return
     */
    public AccountHolderViewModel Create(CreateAccountHolderDto createAccountHolderDto){
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

        return transformHolderToViewModel(accountHolderRepository.save(accountHolder));
    }

    /**
     *
     * @param userLogin
     * @param id
     * @return
     */
    public AccountHolderViewModel getById(User userLogin, Integer id){

        return transformHolderToViewModel(findById(userLogin,id));
    }

    private AccountHolder findById(User userLogin, Integer id){
        User user = parseUser(userLogin);

        if (!checkPermissions(user,id)){
            throw new SecurityAccessException("This user does not have permissions.");
        }

        return accountHolderRepository
                .findById(id).orElseThrow(() -> new DataNotFoundException("this AccountHolder id not Found."));

    }

    /**
     *
     * @param userLogin
     * @param id
     * @param updateAccountHolderDto
     * @return
     */
    public AccountHolderViewModel update(User userLogin, Integer id, UpdateAccountHolderDto updateAccountHolderDto){
        AccountHolder accountHolderFound = findById(userLogin, id);

        accountHolderFound.setBirthday(updateAccountHolderDto.getBirthday());
        accountHolderFound.setFirstName(updateAccountHolderDto.getFirstName());
        accountHolderFound.setLastName(updateAccountHolderDto.getLastName());
        accountHolderFound.setMailingAddress(updateAccountHolderDto.getMailingAddress());
        accountHolderFound.setPrimaryAddress(updateAccountHolderDto.getPrimaryAddress());

        return transformHolderToViewModel(accountHolderRepository.save(accountHolderFound));
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