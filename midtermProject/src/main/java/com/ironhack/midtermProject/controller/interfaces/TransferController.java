package com.ironhack.midtermProject.controller.interfaces;

import com.ironhack.midtermProject.controller.dto.CreateTransferDto;
import com.ironhack.midtermProject.controller.dto.CreateTransactionDto;
import com.ironhack.midtermProject.model.entities.Transfer;
import com.ironhack.midtermProject.model.security.User;

import java.util.List;

public interface TransferController {
    public List<Transfer> getAll();
    public Transfer getById(Integer id);
    public List<Transfer> getAllByIdUser(Integer id);
    public Transfer createTransfer(User user, CreateTransferDto createTransferDto);
    public Transfer createTransaction(User user, CreateTransactionDto createTransactionDto, String hashKey);
}
