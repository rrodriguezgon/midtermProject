/**
 *
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 */
public class CreateTransferDto {

    @NotNull(message = "EmitterAccountId cannot be null")
    private Integer emitterAccountId;

    @NotNull(message = "ReceiverAccountId cannot be null")
    private Integer receiverAccountId;

    @NotEmpty(message = "ReceiverAccountName cannot be empty")
    private String receiverAccountName;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    /**
     *
     */
    public CreateTransferDto(){}

    /**
     *
     * @param emitterAccountId
     * @param receiverAccountId
     * @param receiverAccountName
     * @param amount
     */
    public CreateTransferDto(Integer emitterAccountId, Integer receiverAccountId, String receiverAccountName, BigDecimal amount) {
        this.emitterAccountId = emitterAccountId;
        this.receiverAccountId = receiverAccountId;
        this.receiverAccountName = receiverAccountName;
        this.amount = amount;
    }

    /**
     *
     * @return
     */
    public Integer getEmitterAccountId() {
        return emitterAccountId;
    }

    /**
     *
     * @param emitterAccountId
     */
    public void setEmitterAccountId(Integer emitterAccountId) {
        this.emitterAccountId = emitterAccountId;
    }

    /**
     *
     * @return
     */
    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    /**
     *
     * @param receiverAccountId
     */
    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    /**
     *
     * @return
     */
    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    /**
     *
     * @param receiverAccountName
     */
    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
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
}
