package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StudentCheckingAccountViewModel extends AccountKeyViewModel {

    public StudentCheckingAccountViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner, String secretKey, StatusAccount status) {
        super(id, balance, penaltyFee, createdAt, updatedAt, namePrimaryOwner, nameSecondaryOwner, secretKey, status);
    }
}
