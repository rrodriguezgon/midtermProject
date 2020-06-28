/**
 * com.ironhack.midtermProject.controller.interfaces
 */
package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

/**
 * Saving Account Controller Interface
 */
public interface SavingAccountController {
    /**
     * Get All Saving Accounts
     * @return Display all Saving Accounts
     */
    public List<SavingsAccount> getAll();

    /**
     * Get Saving Account by Id
     * @param user User Logged
     * @param id Saving Account Id
     * @return Display Saving Account by Id
     */
    public SavingsAccount getById(User user, Integer id);

    /**
     * Create Saving Account
     * @param createSavingAccountDto Info for Saving Account
     * @return Display Saving Account created
     */
    public SavingsAccount create(CreateSavingAccountDto createSavingAccountDto);
}
