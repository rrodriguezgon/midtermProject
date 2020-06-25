package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.security.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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

    public Transfer(){}

    public Transfer(Date dateTransfer, BigDecimal amount) {
        this.dateTransfer = dateTransfer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public Account getEmitteraccount() {
        return emitteraccount;
    }

    public void setEmitteraccount(Account emitteraccount) {
        this.emitteraccount = emitteraccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getEmitterUser() {
        return emitterUser;
    }

    public void setEmitterUser(User emitterUser) {
        this.emitterUser = emitterUser;
    }
}