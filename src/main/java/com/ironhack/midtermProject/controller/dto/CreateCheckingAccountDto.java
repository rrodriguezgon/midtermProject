/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * CreateCheckingAccountDto Class
 */
public class CreateCheckingAccountDto {

    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

    @NotEmpty(message = "secretKey cannot be empty")
    private String secretKey;

    @NotNull(message = "PrimaryOwnerId cannot be null")
    private Integer primaryOwnerId;

    private Integer secondaryOwnerId;

    /**
     * Default Constructor CreateCheckingAccountDto.
     */
    public CreateCheckingAccountDto(){}

    /**
     * Constructor CreateCheckingAccountDto.
     * @param balance balance of Account
     * @param secretKey secretKey of Account
     * @param primaryOwnerId Primary Owner Id of Account
     * @param secondaryOwnerId Secondary Owner Id of Account
     */
    public CreateCheckingAccountDto(BigDecimal balance, String secretKey,
                                    Integer primaryOwnerId, Integer secondaryOwnerId) {
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
