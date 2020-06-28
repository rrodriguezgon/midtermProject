/**
 * com.ironhack.midtermProject.controller.impl;
 */
package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateCheckingAccountDto;
import com.ironhack.midtermProject.controller.interfaces.CheckingAccountController;
import com.ironhack.midtermProject.model.entities.Account;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CheckingAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CheckingAccountControllerImpl
 */
@Api(tags = "Checking Account Controller")
@RestController
@RequestMapping("/")
public class CheckingAccountControllerImpl implements CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    /**
     * Get All checking Accounts
     * @return Display all checking Accounts
     */
    @GetMapping("/checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get All checking Accounts",
            notes = "Display all checking Accounts",
            response = Account.class, responseContainer = "List")
    public List<Account> getAll(){
        return checkingAccountService.findAll();
    }

    /**
     * Get checking Account by Id
     * @param user User Logged
     * @param id Checking account Id
     * @return Display checking Account by Id
     */
    @GetMapping("/checking-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get checking Account by Id",
            notes = "Display checking Account by Id",
            response = Account.class)
    public Account getById(@AuthenticationPrincipal User user, @PathVariable Integer id){
        return checkingAccountService.findById(user, id);
    }

    /**
     * Create checking Account
     * @param checkingAccount Info for Create Checking Account
     * @return Display checking Account created
     */
    @PostMapping("/checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create checking Account",
            notes = "Display checking Account created",
            response = Account.class)
    public Account Create(@RequestBody @Valid CreateCheckingAccountDto checkingAccount) {
        return checkingAccountService.Create(checkingAccount);
    }
}
