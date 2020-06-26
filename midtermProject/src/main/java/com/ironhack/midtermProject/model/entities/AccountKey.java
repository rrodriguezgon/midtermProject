/**
 *
 */
package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;

import javax.persistence.*;

/**
 *
 */
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class AccountKey extends Account {

    protected String secretKey;
    protected StatusAccount status;

    /**
     *
     */
    public AccountKey(){
        super();
    }

    /**
     *
     * @param balance
     * @param secretKey
     */
    public AccountKey(Money balance, String secretKey) {
        super(balance);
        this.secretKey = secretKey;
        this.status = StatusAccount.ACTIVE;
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
    public StatusAccount getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(StatusAccount status) {
        this.status = status;
    }
}