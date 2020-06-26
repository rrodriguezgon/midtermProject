/**
 * com.ironhack.midtermProject.controller.interfaces
 */
package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

/**
 * CreditCard Account Controller Interface
 */
public interface CreditCardAccountController {
        /**
         * Get All Credit Card Accounts
         * @return Display all Credit Card Accounts
         */
        public List<CreditCardAccount> getAll();

        /**
         * Get Credit Card Account by Id
         * @param user User Logged
         * @param id Credit Card Account Id
         * @return Display Credit Card Account by Id
         */
        public CreditCardAccount getById(User user, Integer id);

        /**
         * Create Credit Card Account
         * @param createCreditCardAccountDto Info for Credit Card Account
         * @return Display Credit Card Account created
         */
        public CreditCardAccount create(CreateCreditCardAccountDto createCreditCardAccountDto);
}
