/**
 *
 */
package com.ironhack.midtermProject.model.entities;

import javax.persistence.*;

/**
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class StudentCheckingAccount extends AccountKey {

    /**
     *
     */
    public StudentCheckingAccount(){
        super();
    }

    /**
     *
     * @param balance
     * @param secretKey
     */
    public StudentCheckingAccount(Money balance, String secretKey) {
        super(balance,secretKey);
        this.setBalance(balance);
    }
}