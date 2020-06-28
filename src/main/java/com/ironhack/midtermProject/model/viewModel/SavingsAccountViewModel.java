package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingsAccountViewModel extends AccountKeyViewModel {

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    public SavingsAccountViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner, String secretKey, StatusAccount status, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(id, balance, penaltyFee, createdAt, updatedAt, namePrimaryOwner, nameSecondaryOwner, secretKey, status);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
