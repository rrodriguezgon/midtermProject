package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCardAccountViewModel extends AccountViewModel {
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCardAccountViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(id, balance, penaltyFee, createdAt, updatedAt, namePrimaryOwner, nameSecondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
