package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateSavingAccountDto;
import com.ironhack.midtermProject.model.entities.SavingsAccount;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.SavingAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Saving Account Controller")
@RestController
@RequestMapping("/")
public class SavingAccountControllerImpl {
    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping("/savings-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccount> getAll() {
        return savingAccountService.findAll();
    }

    @GetMapping("/savings-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccount getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return savingAccountService.getById(user,id);
    }

    @PostMapping("/savings-account")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccount create(@RequestBody @Valid CreateSavingAccountDto createSavingAccountDto) {
        return savingAccountService.Create(createSavingAccountDto);
    }
}
