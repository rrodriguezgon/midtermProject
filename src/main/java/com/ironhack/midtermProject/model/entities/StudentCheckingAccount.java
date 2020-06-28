/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import javax.persistence.*;

/**
 * StudentCheckingAccount Class.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class StudentCheckingAccount extends AccountKey {

    /**
     * Default Constructor StudentCheckingAccount.
     */
    public StudentCheckingAccount(){
        super();
    }

    /**
     * Constructor StudentCheckingAccount.
     * @param balance balance of CheckingAccount.
     * @param secretKey secretkey of SavingsAccount.
     */
    public StudentCheckingAccount(Money balance, String secretKey) {
        super(balance,secretKey);
        this.setBalance(balance);
    }
}