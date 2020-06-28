/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * CreateCreditCardAccountDto Class
 */
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

    /**
     * Default Constructor CreateCreditCardAccountDto.
     */
    public CreateCreditCardAccountDto(){}

    /**
     * Constructor CreateCreditCardAccountDto.
     * @param creditLimit creditLimit of Account
     * @param interestRate interestRate of Account
     * @param balance balance of Account
     * @param primaryOwnerId Primary Owner Id of Account
     * @param secondaryOwnerId Secondary Owner Id of Account
     */
    public CreateCreditCardAccountDto(BigDecimal creditLimit, BigDecimal interestRate, BigDecimal balance,
                                      Integer primaryOwnerId,Integer secondaryOwnerId) {
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
    }

    /**
     * Getter creditLimit of Account
     * @return creditLimit of Account
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Setter creditLimit of Account
     * @param creditLimit creditLimit of Account
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
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