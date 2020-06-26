/**
 *
 */
package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.controller.dto.CreateTransactionDto;
import com.ironhack.midtermProject.model.entities.Transfer;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

/**
 * Transfer Controller Interface
 */
public interface TransferController {

    /**
     * Get All transfers
     * @return Display all Credit Card Accounts
     */
    public List<Transfer> getAll();

    /**
     * Get transfer by Id
     * @param id Transfer Id
     * @return Display Transfer by Id
     */
    public Transfer getById(Integer id);

    /**
     * Create Transference
     * @param user User Logged
     * @param createTransferDto Info for Transference
     * @return Display Transference created
     */
    public Transfer createTransfer(User user, CreateTransferDto createTransferDto);

    /**
     * Create Transaction
     * @param user User Logged
     * @param createTransactionDto
     * @param hashKey Thirdparty HashKey
     * @return Display Transaction created
     */
    public Transfer createTransaction(User user, CreateTransactionDto createTransactionDto, String hashKey);
}
