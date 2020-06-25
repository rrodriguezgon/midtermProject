package com.ironhack.midtermProject.controller.interfaces.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

public interface AccountHolderController {

    public List<AccountHolder> getAll();
    public AccountHolder Create(CreateAccountHolderDto accountHolder);
    public AccountHolder getById(User user, Integer id);
    public AccountHolder update(User user,Integer id, UpdateAccountHolderDto accountHolder);
    public void deleteById(User user,Integer id);

}
