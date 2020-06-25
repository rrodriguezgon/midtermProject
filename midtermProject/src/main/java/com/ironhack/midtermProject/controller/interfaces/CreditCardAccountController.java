package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

public interface CreditCardAccountController {
        public List<CreditCardAccount> getAll();
        public CreditCardAccount getById(User user, Integer id);
        public CreditCardAccount create(CreateCreditCardAccountDto createCreditCardAccountDto);
}
