/**
 * com.ironhack.midtermProject.controller.impl
 */
package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.SavingAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Saving Account Controller
 */
@Api(tags = "Saving Account Controller")
@RestController
@RequestMapping("/")
public class SavingAccountControllerImpl {

    @Autowired
    private SavingAccountService savingAccountService;

    /**
     * Get All Saving Accounts
     * @return Display all Saving Accounts
     */
    @GetMapping("/savings-accounts")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get All Saving Accounts",
            notes = "Display all Saving Accounts",
            response = SavingsAccount.class, responseContainer = "List")
    public List<SavingsAccount> getAll() {
        return savingAccountService.findAll();
    }

    /**
     * Get Saving Account by Id
     * @param user User Logged
     * @param id Saving Account Id
     * @return Display Saving Account by Id
     */
    @ApiOperation(value="Get Saving Account by Id",
            notes = "Display Saving Account by Id",
            response = SavingsAccount.class)
    @GetMapping("/savings-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccount getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return savingAccountService.getById(user,id);
    }

    /**
     * Create Saving Account
     * @param createSavingAccountDto Info for Saving Account
     * @return Display Saving Account created
     */
    @PostMapping("/savings-account")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create Saving Account",
            notes = "Display Saving Account created",
            response = SavingsAccount.class)
    public SavingsAccount create(@RequestBody @Valid CreateSavingAccountDto createSavingAccountDto) {
        return savingAccountService.Create(createSavingAccountDto);
    }
}
