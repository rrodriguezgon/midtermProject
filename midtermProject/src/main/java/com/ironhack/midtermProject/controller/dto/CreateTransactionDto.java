/**
 *
 */
package com.ironhack.midtermProject.controller.dto;

import com.ironhack.midtermProject.enums.TypeTransaction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 */
public class CreateTransactionDto {
    @NotNull(message = "AccountId cannot be null")
    private Integer accountId;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotEmpty(message = "secretKey cannot be empty")
    private String secretKey;

    @NotNull(message = "TypeTransaction cannot be null")
    private TypeTransaction typeTransaction;

    /**
     *
     */
    public CreateTransactionDto(){}

    /**
     *
     * @param accountId
     * @param amount
     * @param secretKey
     * @param typeTransaction
     */
    public CreateTransactionDto(Integer accountId, BigDecimal amount, String secretKey, TypeTransaction typeTransaction) {
        this.accountId = accountId;
        this.amount = amount;
        this.secretKey = secretKey;
        this.typeTransaction = typeTransaction;
    }

    /**
     *
     * @return
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    /**
     *
     * @param typeTransaction
     */
    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
}