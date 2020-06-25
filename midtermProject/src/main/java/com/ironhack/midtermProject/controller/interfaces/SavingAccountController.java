package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

public interface SavingAccountController {
    public List<SavingsAccount> getAll();
    public SavingsAccount getById(User user, Integer id);
    public SavingsAccount create(CreateSavingAccountDto createSavingAccountDto);
}
