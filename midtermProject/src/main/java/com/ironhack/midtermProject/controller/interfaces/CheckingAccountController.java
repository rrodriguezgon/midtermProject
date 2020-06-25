package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.model.entities.Account;

import java.util.List;

public interface CheckingAccountController {

    public List<Account> getAll();

    public Account Create(CreateCheckingAccountDto checkingAccount);

}
