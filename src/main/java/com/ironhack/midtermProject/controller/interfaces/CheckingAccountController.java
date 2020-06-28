/**
 * com.ironhack.midtermProject.controller.interfaces
 */
package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

/**
 * CheckingAccountControllerImpl Interface
 */
public interface CheckingAccountController {

    /**
     * Get All checking Accounts
     * @return Display all checking Accounts
     */
    public List<Account> getAll();

    /**
     * Get checking Account by Id
     * @param user User Logged
     * @param id Checking account Id
     * @return Display checking Account by Id
     */
    public Account getById(User user, Integer id);

    /**
     * Create checking Account
     * @param checkingAccount Info for Create Checking Account
     * @return Display checking Account created
     */
    public Account Create(CreateCheckingAccountDto checkingAccount);

}
