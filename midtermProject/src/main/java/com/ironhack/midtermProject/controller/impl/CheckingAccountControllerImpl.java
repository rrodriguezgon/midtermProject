package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.controller.interfaces.CheckingAccountController;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CheckingAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Checking Account Controller")
@RestController
@RequestMapping("/")
public class CheckingAccountControllerImpl implements CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @GetMapping("/checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAll(){
        return checkingAccountService.findAll();
    }

    @GetMapping("/checking-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getById(@AuthenticationPrincipal User user, @PathVariable Integer id){
        return checkingAccountService.findById(user, id);
    }

    @PostMapping("/checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account Create(@RequestBody @Valid CreateCheckingAccountDto checkingAccount) {
        return checkingAccountService.Create(checkingAccount);
    }
}
