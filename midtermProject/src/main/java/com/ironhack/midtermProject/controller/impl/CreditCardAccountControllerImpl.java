/**
 * com.ironhack.midtermProject.controller.impl
 */
package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.interfaces.CreditCardAccountController;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CreditCardAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CreditCard Account Controller
 */
@Api(tags = "CreditCard Account Controller")
@RestController
@RequestMapping("/")
public class CreditCardAccountControllerImpl implements CreditCardAccountController {

    private static final Logger LOGGER = LogManager.getLogger(CreditCardAccountControllerImpl.class);

    @Autowired
    private CreditCardAccountService creditCardAccountService;

    /**
     * Get All Credit Card Accounts
     * @return Display all Credit Card Accounts
     */
    @ApiOperation(value="Get All Credit Card Accounts",
            notes = "Display all Credit Card Accounts",
            response = CreditCardAccount.class, responseContainer = "List")
    @GetMapping("/credit-card-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardAccount> getAll() {
        return creditCardAccountService.findAll();
    }

    /**
     * Get Credit Card Account by Id
     * @param user User Logged
     * @param id Credit Card Account Id
     * @return Display Credit Card Account by Id
     */
    @ApiOperation(value="Get Credit Card Account by Id",
            notes = "Display Credit Card Account by Id",
            response = CreditCardAccount.class)
    @GetMapping("/credit-card-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardAccount getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return creditCardAccountService.getById(user,id);
    }

    /**
     * Create Credit Card Account
     * @param createCreditCardAccountDto Info for Credit Card Account
     * @return Display Credit Card Account created
     */
    @PostMapping("/credit-card-account")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create Credit Card Account",
            notes = "Display Credit Card Account created",
            response = CreditCardAccount.class)
    public CreditCardAccount create(@RequestBody @Valid CreateCreditCardAccountDto createCreditCardAccountDto) {
        return creditCardAccountService.Create(createCreditCardAccountDto);
    }
}
