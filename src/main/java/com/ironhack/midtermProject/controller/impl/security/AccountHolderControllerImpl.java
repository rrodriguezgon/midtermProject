/**
 * com.ironhack.midtermProject.controller.impl.security
 */
package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.*;
import com.ironhack.midtermProject.controller.interfaces.security.AccountHolderController;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.model.viewModel.AccountHolderViewModel;
import com.ironhack.midtermProject.service.security.AccountHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * AccountHolder Controller
 */
@Api(tags = "AccountHolder Controller")
@RestController
@RequestMapping("/")
public class AccountHolderControllerImpl implements AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    /**
     * Get All AccountHolders
     * @return Display all account holders
     */
    @GetMapping("/accounts-holder")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get All AccountHolders",
            notes = "Display all account holders",
            response = AccountHolder.class, responseContainer = "List")
    public List<AccountHolderViewModel> getAll() {
        return accountHolderService.findAll();
    }

    /**
     * Get AccountHolder by Id
     * @param user Logged User
     * @param id Id Account Holder
     * @return Display account holder by Id
     */
    @GetMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get AccountHolder by Id",
            notes = "Display account holder by Id",
            response = AccountHolder.class)
    public AccountHolderViewModel getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return accountHolderService.getById(user,id);
    }

    /**
     * Create AccountHolder
     * @param accountHolder Info for Create Account Holder
     * @return Display account holder created
     */
    @PostMapping("/accounts-holder")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create AccountHolder",
            notes = "Display account holder created",
            response = AccountHolder.class)
    public AccountHolderViewModel create(@RequestBody @Valid CreateAccountHolderDto accountHolder) {
        return accountHolderService.Create(accountHolder);
    }

    /**
     * Update AccountHolder
     * @param user Logged User
     * @param id Id Account Holder
     * @param accountHolder Info for Update Account Holder
     */
    @PutMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update AccountHolder")
    public void update(@AuthenticationPrincipal User user,@PathVariable Integer id, @RequestBody @Valid UpdateAccountHolderDto accountHolder) {
        accountHolderService.update(user,id, accountHolder);
    }

    /**
     * deleteById AccountHolder
     * @param user Logged User
     * @param id Id Account Holder
     */
    @DeleteMapping("/accounts-holder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete AccountHolder")
    public void deleteById(@AuthenticationPrincipal User user,@PathVariable Integer id) {
        accountHolderService.deleteById(user,id);
    }
}