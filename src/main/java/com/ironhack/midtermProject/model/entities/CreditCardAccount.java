/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.security.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * CreditCardAccount Class.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class CreditCardAccount extends Account {

    private final BigDecimal MIN_CREDITLIMIT = new BigDecimal("100");

    private final BigDecimal MIN_RATE = new BigDecimal("0.2");

    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    /**
     * Default Constructor CreditCardAccount.
     */
    public CreditCardAccount(){
        super();
    }

    /**
     * Constructor CreditCardAccount
     * @param creditLimit creditLimit of CreditCardAccount
     * @param interestRate interestRate of CreditCardAccount
     * @param balance balance of CreditCardAccount
     */
    public CreditCardAccount( BigDecimal creditLimit,
                              BigDecimal interestRate, Money balance) {
        super(balance);

        if (creditLimit != null){
            this.creditLimit = creditLimit;
        } else {
            this.creditLimit = MIN_CREDITLIMIT;
        }

        if (interestRate != null){
            this.interestRate = interestRate;
        } else {
            this.interestRate = MIN_RATE;
        }
    }

    /**
     * Getter MIN_CREDITLIMIT of CreditCardAccount
     * @return MIN_CREDITLIMIT of CreditCardAccount
     */
    @JsonIgnore
    public BigDecimal getMIN_CREDITLIMIT() {
        return MIN_CREDITLIMIT;
    }

    /**
     * Getter MIN_RATE of CreditCardAccount
     * @return MIN_RATE of CreditCardAccount
     */
    @JsonIgnore
    public BigDecimal getMIN_RATE() {
        return MIN_RATE;
    }

    /**
     * Getter creditLimit of CreditCardAccount
     * @return creditLimit of CreditCardAccount
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Setter creditLimit of CreditCardAccount
     * @param creditLimit creditLimit of CreditCardAccount
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Geter interestRate of CreditCardAccount
     * @return interestRate of CreditCardAccount
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Setter interestRate of CreditCardAccount
     * @param interestRate interestRate of CreditCardAccount
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}