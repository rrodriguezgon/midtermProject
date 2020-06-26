package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.exception.*;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.repository.security.AccountHolderRepository;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    public List<AccountHolder> findAll(){
        return accountHolderRepository.findAll();
    }

    public AccountHolder Create(CreateAccountHolderDto createAccountHolderDto){
        AccountHolder user = accountHolderRepository.findByUsername(createAccountHolderDto.getUsername());

        if (user != null){
            throw new UserExistException("This user exists.");
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

    public AccountHolder findById(User userLogin, Integer id){
        User user = parseUser(userLogin);

        if (!checkPermissions(user,id)){
            throw new SecurityAccessException("This user does not have permissions.");
        }

        return accountHolderRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this AccountHolder id not Found."));
    }

    public AccountHolder update(User userLogin, Integer id, UpdateAccountHolderDto updateAccountHolderDto){
        AccountHolder accountHolderFound = findById(userLogin, id);

        accountHolderFound.setBirthday(updateAccountHolderDto.getBirthday());
        accountHolderFound.setFirstName(updateAccountHolderDto.getFirstName());
        accountHolderFound.setLastName(updateAccountHolderDto.getLastName());
        accountHolderFound.setMailingAddress(updateAccountHolderDto.getMailingAddress());
        accountHolderFound.setPrimaryAddress(updateAccountHolderDto.getPrimaryAddress());

        return accountHolderRepository.save(accountHolderFound);
    }

    public void deleteById(User userLogin, Integer id){
        AccountHolder accountHolder = findById(userLogin, id);

        accountHolderRepository.delete(accountHolder);
    }

    private Boolean checkPermissions(User user, Integer id) {
        if ((user instanceof Admin) == false){
            return user.getId() == id;
        } else {
            return true;
        }
    }

    private User parseUser(User userLogin){
        User user = adminRepository.findByUsername(userLogin.getUsername());
        if (user == null){
            user = accountHolderRepository.findByUsername(userLogin.getUsername());
        }

        return user;
    }
}
