package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class AccountKey extends Account {

    protected String secretKey;
    protected StatusAccount status;

    public AccountKey(){
        super();
    }

    public AccountKey(Money balance, String secretKey) {
        super(balance);
        this.secretKey = secretKey;
        this.status = StatusAccount.ACTIVE;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public StatusAccount getStatus() {
        return status;
    }

    public void setStatus(StatusAccount status) {
        this.status = status;
    }
}