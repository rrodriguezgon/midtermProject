/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 *
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
     *
     */
    public CreateCreditCardAccountDto(){}

    /**
     *
     * @param creditLimit
     * @param interestRate
     * @param balance
     * @param primaryOwnerId
     * @param secondaryOwnerId
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
     *
     * @return
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     *
     * @param creditLimit
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     *
     * @return
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     *
     * @param interestRate
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     *
     * @return
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public Integer getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    /**
     *
     * @param primaryOwnerId
     */
    public void setPrimaryOwnerId(Integer primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    /**
     *
     * @return
     */
    public Integer getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    /**
     *
     * @param secondaryOwnerId
     */
    public void setSecondaryOwnerId(Integer secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }
}