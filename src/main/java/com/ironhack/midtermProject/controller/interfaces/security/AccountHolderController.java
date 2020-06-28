/**
 * com.ironhack.midtermProject.controller.interfaces.security
 */
package com.ironhack.midtermProject.controller.interfaces.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.model.viewModel.AccountHolderViewModel;

import java.util.List;

/**
 * AccountHolder Controller Interface
 */
public interface AccountHolderController {

    /**
     * Get All AccountHolders
     * @return Display all account holders
     */
    public List<AccountHolderViewModel> getAll();

    /**
     * Create AccountHolder
     * @param accountHolder Info for Create Account Holder
     * @return Display account holder created
     */
    public AccountHolderViewModel create(CreateAccountHolderDto accountHolder);

    /**
     * Get AccountHolder by Id
     * @param user Logged User
     * @param id Id Account Holder
     * @return Display account holder by Id
     */
    public AccountHolderViewModel getById(User user, Integer id);

    /**
     * Update AccountHolder
     * @param user Logged User
     * @param id Id Account Holder
     * @param accountHolder Info for Update Account Holder
     */
    public void update(User user,Integer id, UpdateAccountHolderDto accountHolder);

    /**
     * deleteById AccountHolder
     * @param user Logged User
     * @param id Id Account Holder
     */
    public void deleteById(User user,Integer id);

}
