/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import com.ironhack.midtermProject.enums.TypeTransaction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * CreateTransactionDto Class
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
     * Default Constructor CreateTransactionDto.
     */
    public CreateTransactionDto(){}

    /**
     * CreateTransactionDto
     * @param accountId Account Id Transaction
     * @param amount Amount Transaction
     * @param secretKey secretKey Transaction
     * @param typeTransaction type of Transaction
     */
    public CreateTransactionDto(Integer accountId, BigDecimal amount, String secretKey, TypeTransaction typeTransaction) {
        this.accountId = accountId;
        this.amount = amount;
        this.secretKey = secretKey;
        this.typeTransaction = typeTransaction;
    }

    /**
     * Getter Account Id Transaction
     * @return Account Id Transaction
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * Setter Account Id Transaction
     * @param accountId Account Id Transaction
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter Amount Transaction
     * @return Amount Transaction
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter Amount Transaction
     * @param amount Amount Transaction
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Getter secretKey Transaction
     * @return secretKey Transaction
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Setter secretKey Transaction
     * @param secretKey secretKey Transaction
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Getter type of Transaction
     * @return type of Transaction
     */
    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    /**
     * Setter type of Transaction
     * @param typeTransaction type of Transaction
     */
    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
}