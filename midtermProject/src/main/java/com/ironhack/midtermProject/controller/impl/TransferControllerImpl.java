/**
 * com.ironhack.midtermProject.controller.impl
 */
package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.controller.dto.CreateTransactionDto;
import com.ironhack.midtermProject.controller.interfaces.TransferController;
import com.ironhack.midtermProject.model.entities.Transfer;
import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.service.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Transfer Controller
 */
@Api(tags = "Transfer Controller")
@RestController
@RequestMapping("/")
public class TransferControllerImpl implements TransferController {

    @Autowired
    private TransferService transferService;

    /**
     * Get All transfers
     * @return Display all Credit Card Accounts
     */
    @ApiOperation(value="Get All transfers",
            notes = "Display all transfers",
            response = Transfer.class, responseContainer = "List")
    @GetMapping("/transfers")
    @ResponseStatus(HttpStatus.OK)
    public List<Transfer> getAll() {
        return transferService.findAll();
    }

    /**
     * Get transfer by Id
     * @param id Transfer Id
     * @return Display Transfer by Id
     */
    @ApiOperation(value="Get Transfer by Id",
            notes = "Display Transfer by Id",
            response = Transfer.class)
    @GetMapping("/transfers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transfer getById(@PathVariable Integer id) {
        return new Transfer();
    }

    /**
     * Create Transference
     * @param user User Logged
     * @param createTransferDto Info for Transference
     * @return Display Transference created
     */
    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create Transference",
            notes = "Display Transference created",
            response = Transfer.class)
    public Transfer createTransfer(@AuthenticationPrincipal User user,
                                   @RequestBody @Valid CreateTransferDto createTransferDto) {
        return transferService.createTransfer(user, createTransferDto);
    }

    /**
     * Create Transaction
     * @param user User Logged
     * @param createTransactionDto
     * @param hashKey Thirdparty HashKey
     * @return Display Transaction created
     */
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create Transaction",
            notes = "Display Transference created",
            response = Transfer.class)
    public Transfer createTransaction(@AuthenticationPrincipal User user,
                                      @RequestBody @Valid CreateTransactionDto createTransactionDto,
                                      @RequestHeader("hashKey") String hashKey) {
        return transferService.createTransaction(user, createTransactionDto, hashKey);
    }
}
