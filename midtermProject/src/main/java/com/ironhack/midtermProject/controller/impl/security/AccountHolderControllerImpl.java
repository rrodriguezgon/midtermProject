package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAccountHolderDto;
import com.ironhack.midtermProject.controller.dto.security.UpdateAccountHolderDto;
import com.ironhack.midtermProject.controller.interfaces.security.AccountHolderController;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.security.AccountHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "AccountHolder Controller")
@RestController
@RequestMapping("/")
public class AccountHolderControllerImpl implements AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping("/accounts-holder")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAll() {
        return accountHolderService.findAll();
    }

    @GetMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        AccountHolder accountHolder = accountHolderService.findById(user,id);
        return accountHolder;
    }

    @PostMapping("/accounts-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder Create(@RequestBody @Valid CreateAccountHolderDto accountHolder) {
        return accountHolderService.Create(accountHolder);
    }

    @PutMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AccountHolder update(@AuthenticationPrincipal User user,@PathVariable Integer id, @RequestBody @Valid UpdateAccountHolderDto accountHolder) {
        return accountHolderService.update(user,id, accountHolder);
    }

    @DeleteMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@AuthenticationPrincipal User user,@PathVariable Integer id) {
        accountHolderService.deleteById(user,id);
    }
}