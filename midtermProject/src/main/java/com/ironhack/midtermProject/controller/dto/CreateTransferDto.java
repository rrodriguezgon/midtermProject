/**
 * com.ironhack.midtermProject.controller.dto
 */
package com.ironhack.midtermProject.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * CreateTransferDto Class
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
     * Default Constructor CreateTransferDto.
     */
    public CreateTransferDto(){}

    /**
     * Constructor CreateTransferDto.
     * @param emitterAccountId Account Emitter Id of Transference
     * @param receiverAccountId Account Receiver Id of Transference
     * @param receiverAccountName Account Receiver Name of Transference
     * @param amount Amount of Transference
     */
    public CreateTransferDto(Integer emitterAccountId, Integer receiverAccountId, String receiverAccountName, BigDecimal amount) {
        this.emitterAccountId = emitterAccountId;
        this.receiverAccountId = receiverAccountId;
        this.receiverAccountName = receiverAccountName;
        this.amount = amount;
    }

    /**
     * Getter Account Emitter Id of Transference
     * @return Account Emitter Id of Transference
     */
    public Integer getEmitterAccountId() {
        return emitterAccountId;
    }

    /**
     * Setter Account Emitter Id of Transference
     * @param emitterAccountId Account Emitter Id of Transference
     */
    public void setEmitterAccountId(Integer emitterAccountId) {
        this.emitterAccountId = emitterAccountId;
    }

    /**
     * Getter Account Receiver Id of Transference
     * @return Account Receiver Id of Transference
     */
    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    /**
     * Setter Account Receiver Id of Transference
     * @param receiverAccountId Account Receiver Id of Transference
     */
    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    /**
     * Getter Account Receiver Name of Transference
     * @return Account Receiver Name of Transference
     */
    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    /**
     * Setter Account Receiver Name of Transference
     * @param receiverAccountName Account Receiver Name of Transference
     */
    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    /**
     * Getter amount of Transference
     * @return amount of Transference
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter amount of Transference
     * @param amount amount of Transference
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
