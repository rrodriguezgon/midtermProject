package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;

import java.math.BigDecimal;

public class CreateSavingAccountDto {

    @DecimalMin(value = "0.0025", inclusive = true, message = "the parameter interestRate is less than the minimum it is: 0.0025")
    @DecimalMax(value = "0.5", inclusive = true, message = "the parameter interestRate is greater than the maximum it is: 0.5")
    private BigDecimal interestRate;

    @DecimalMin(value = "100.0", inclusive = true, message = "the parameter balance is less than the minimum it is: 100")
    @DecimalMax(value = "1000.0", inclusive = true, message = "the parameter balance is greater than the maximum it is: 1000")
    private BigDecimal balance;

    @NotEmpty(message = "secretKey cannot be empty")
    private String secretKey;

    @NotNull(message = "PrimaryOwnerId cannot be null")
    private Integer primaryOwnerId;

    private Integer secondaryOwnerId;

    public CreateSavingAccountDto(){}

    public CreateSavingAccountDto(BigDecimal interestRate, BigDecimal balance, String secretKey,
                                   Integer primaryOwnerId, Integer secondaryOwnerId) {
        this.interestRate = interestRate;
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
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
