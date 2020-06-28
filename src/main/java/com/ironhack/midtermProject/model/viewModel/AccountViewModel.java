package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class AccountViewModel {
    protected Integer id;

    protected Money balance;

    protected BigDecimal penaltyFee;

    protected LocalDate createdAt;

    protected LocalDate updatedAt;

    protected String namePrimaryOwner;

    protected String nameSecondaryOwner;

    public AccountViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner) {
        this.id = id;
        this.balance = balance;
        this.penaltyFee = penaltyFee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.namePrimaryOwner = namePrimaryOwner;
        this.nameSecondaryOwner = nameSecondaryOwner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNamePrimaryOwner() {
        return namePrimaryOwner;
    }

    public void setNamePrimaryOwner(String namePrimaryOwner) {
        this.namePrimaryOwner = namePrimaryOwner;
    }

    public String getNameSecondaryOwner() {
        return nameSecondaryOwner;
    }

    public void setNameSecondaryOwner(String nameSecondaryOwner) {
        this.nameSecondaryOwner = nameSecondaryOwner;
    }
}
