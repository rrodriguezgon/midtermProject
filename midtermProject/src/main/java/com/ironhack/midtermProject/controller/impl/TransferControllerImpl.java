package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.controller.dto.CreateTransactionDto;
import com.ironhack.midtermProject.controller.impl.security.AccountHolderControllerImpl;
import com.ironhack.midtermProject.controller.interfaces.TransferController;
import com.ironhack.midtermProject.model.entities.Transfer;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.TransferService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Transfer Controller")
@RestController
@RequestMapping("/")
public class TransferControllerImpl implements TransferController {

    private static final Logger LOGGER = LogManager.getLogger(TransferControllerImpl.class);

    @Autowired
    private TransferService transferService;

    @GetMapping("/transfers")
    @ResponseStatus(HttpStatus.OK)
    public List<Transfer> getAll() {
        return transferService.findAll();
    }

    @GetMapping("/transfers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transfer getById(@PathVariable Integer id) {
        return new Transfer();
    }

    @GetMapping("/transfer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transfer> getAllByIdUser(@PathVariable Integer id) {
        return transferService.findAlllByUserId(id);
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    public Transfer createTransfer(@AuthenticationPrincipal User user,
                                   @RequestBody @Valid CreateTransferDto createTransferDto) {
        return transferService.createTransfer(user, createTransferDto);
    }

    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transfer createTransaction(@AuthenticationPrincipal User user,
                                      @RequestBody @Valid CreateTransactionDto createTransactionDto,
                                      @RequestHeader("hashKey") String hashKey) {
        return transferService.createTransaction(user, createTransactionDto, hashKey);
    }
}
