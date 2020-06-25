package com.ironhack.midtermProject.controller.dto;

import com.ironhack.midtermProject.model.entities.Money;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CreateCreditCardAccountDto {

    @DecimalMin(value = "100.0", inclusive = true, message = "the parameter creditLimit is less than the minimum it is: 100")
    @DecimalMax(value = "1000.0", inclusive = true, message = "the parameter creditLimit is greater than the maximum it is: 1000")
    BigDecimal creditLimit;

    @DecimalMin(value = "0.1", inclusive = true, message = "the parameter interestRate is less than the minimum it is: 0.1")
    @DecimalMax(value = "0.2", inclusive = true, message = "the parameter interestRate is greater than the maximum it is: 0.2")
    BigDecimal interestRate;

    @NotNull(message = "Balance cannot be null")
    BigDecimal balance;

    @NotNull(message = "PrimaryOwnerId cannot be null")
    private Integer primaryOwnerId;

    private Integer secondaryOwnerId;

    public CreateCreditCardAccountDto(){}

    public CreateCreditCardAccountDto(BigDecimal creditLimit, BigDecimal interestRate, BigDecimal balance,
                                      Integer primaryOwnerId,Integer secondaryOwnerId) {
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Integer primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Integer getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Integer secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }
}