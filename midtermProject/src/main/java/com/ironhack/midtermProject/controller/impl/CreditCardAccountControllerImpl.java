package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateCreditCardAccountDto;
import com.ironhack.midtermProject.controller.impl.security.AccountHolderControllerImpl;
import com.ironhack.midtermProject.controller.interfaces.CreditCardAccountController;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.CreditCardAccountService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "CreditCard Account Controller")
@RestController
@RequestMapping("/")
public class CreditCardAccountControllerImpl implements CreditCardAccountController {

    private static final Logger LOGGER = LogManager.getLogger(CreditCardAccountControllerImpl.class);

    @Autowired
    private CreditCardAccountService creditCardAccountService;

    @GetMapping("/credit-card-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardAccount> getAll() {
        return creditCardAccountService.findAll();
    }

    @GetMapping("/credit-card-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardAccount getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return creditCardAccountService.getById(user,id);
    }

    @PostMapping("/credit-card-account")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardAccount create(@RequestBody @Valid CreateCreditCardAccountDto createCreditCardAccountDto) {
        return creditCardAccountService.Create(createCreditCardAccountDto);
    }
}
