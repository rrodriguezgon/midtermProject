/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * CreateSavingAccountDto Class
 */
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

    /**
     * Default Constructor CreateSavingAccountDto.
     */
    public CreateSavingAccountDto(){}

    /**
     * Constructor CreateSavingAccountDto
     * @param interestRate interestRate of Account
     * @param balance balance of Account
     * @param secretKey secretKey of Account
     * @param primaryOwnerId Primary Owner Id of Account
     * @param secondaryOwnerId Secondary Owner Id of Account
     */
    public CreateSavingAccountDto(BigDecimal interestRate, BigDecimal balance, String secretKey,
                                   Integer primaryOwnerId, Integer secondaryOwnerId) {
        this.interestRate = interestRate;
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
    }

    /**
     * Getter balance of Account
     * @return balance of Account
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Setter balance of Account
     * @param balance balance of Account
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Getter secretKey of Account
     * @return secretKey of Account
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Setter secretKey of Account
     * @param secretKey secretKey of Account
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Getter interestRate of Account
     * @return interestRate of Account
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Setter interestRate of Account
     * @param interestRate interestRate of Account
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Getter Primary Owner Id of Account
     * @return Primary Owner Id of Account
     */
    public Integer getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    /**
     * Setter Primary Owner Id of Account
     * @param primaryOwnerId Primary Owner Id of Account
     */
    public void setPrimaryOwnerId(Integer primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    /**
     * Getter Secondary Owner Id of Account
     * @return Secondary Owner Id of Account
     */
    public Integer getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    /**
     * Setter Secondary Owner Id of Account
     * @param secondaryOwnerId Secondary Owner Id of Account
     */
    public void setSecondaryOwnerId(Integer secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }
}
