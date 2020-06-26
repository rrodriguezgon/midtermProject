/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 *
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
     *
     */
    public CreateCheckingAccountDto(){}

    /**
     *
     * @param balance
     * @param secretKey
     * @param primaryOwnerId
     * @param secondaryOwnerId
     */
    public CreateCheckingAccountDto(BigDecimal balance, String secretKey,
                                    Integer primaryOwnerId, Integer secondaryOwnerId) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
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
    public String getSecretKey() {
        return secretKey;
    }

    /**
     *
     * @param secretKey
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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
