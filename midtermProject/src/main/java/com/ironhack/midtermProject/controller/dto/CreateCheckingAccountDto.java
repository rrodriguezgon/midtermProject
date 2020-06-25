package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CreateCheckingAccountDto {

    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

    @NotEmpty(message = "secretKey cannot be empty")
    private String secretKey;

    @NotNull(message = "PrimaryOwnerId cannot be null")
    private Integer primaryOwnerId;

    private Integer secondaryOwnerId;

    public CreateCheckingAccountDto(){}

    public CreateCheckingAccountDto(BigDecimal balance, String secretKey,
                                    Integer primaryOwnerId, Integer secondaryOwnerId) {
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
