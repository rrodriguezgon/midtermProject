/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.security.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Transfer Class.
 */
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateTransfer;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User emitterUser;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="emitteraccount_id")
    private Account emitteraccount;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="receiverAccount_id")
    private Account receiverAccount;

    private BigDecimal amount;

    /**
     * Default Constructor Transfer.
     */
    public Transfer(){}

    /**
     * Constructor Transfer.
     * @param dateTransfer date of Transfer
     * @param amount Amount of Transfer
     */
    public Transfer(Date dateTransfer, BigDecimal amount) {
        this.dateTransfer = dateTransfer;
        this.amount = amount;
    }

    /**
     * Getter Id of Transfer
     * @return Id of Transfer
     */
    public int getId() {
        return id;
    }

    /**
     * Setter Id of Transfer
     * @param id Id of Transfer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter dateTransfer of Transfer
     * @return dateTransfer of Transfer
     */
    public Date getDateTransfer() {
        return dateTransfer;
    }

    /**
     * Setter dateTransfer of Transfer
     * @param dateTransfer dateTransfer of Transfer
     */
    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    /**
     * Getter emitteraccount of Transfer
     * @return emitteraccount of Transfer
     */
    public Account getEmitteraccount() {
        return emitteraccount;
    }

    /**
     * Setter emitteraccount of Transfer
     * @param emitteraccount emitteraccount of Transfer
     */
    public void setEmitteraccount(Account emitteraccount) {
        this.emitteraccount = emitteraccount;
    }

    /**
     * Getter receiverAccount of Transfer
     * @return receiverAccount of Transfer
     */
    public Account getReceiverAccount() {
        return receiverAccount;
    }

    /**
     * Setter receiverAccount of Transfer
     * @param receiverAccount receiverAccount of Transfer
     */
    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    /**
     * Getter amount of Transfer
     * @return amount of Transfer
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter amount of Transfer
     * @param amount amount of Transfer
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Getter emitterUser of Transfer
     * @return emitterUser of Transfer
     */
    public User getEmitterUser() {
        return emitterUser;
    }

    /**
     * Setter emitterUser of Transfer
     * @param emitterUser emitterUser of Transfer
     */
    public void setEmitterUser(User emitterUser) {
        this.emitterUser = emitterUser;
    }
}