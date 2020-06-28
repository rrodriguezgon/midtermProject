/**
 *com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;

import javax.persistence.*;

/**
 * AccountKey Class.
 */
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class AccountKey extends Account {

    protected String secretKey;
    protected StatusAccount status;

    /**
     * Default Constructor AccountKey.
     */
    public AccountKey(){
        super();
    }

    /**
     * Constructor AccountKey.
     * @param balance balance of Account Key.
     * @param secretKey secretkey of Account Key.
     */
    public AccountKey(Money balance, String secretKey) {
        super(balance);
        this.secretKey = secretKey;
        this.status = StatusAccount.ACTIVE;
    }

    /**
     * Getter secretkey of Account Key.
     * @return secretkey of Account Key.
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Setter secretkey of Account Key.
     * @param secretKey secretkey of Account Key.
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Getter balance of Account Key.
     * @return balance of Account Key.
     */
    public StatusAccount getStatus() {
        return status;
    }

    /**
     * Setter balance of Account Key.
     * @param status balance of Account Key.
     */
    public void setStatus(StatusAccount status) {
        this.status = status;
    }
}