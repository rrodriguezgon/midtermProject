/**
 *
 */
package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.security.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class CreditCardAccount extends Account {

    private final BigDecimal MIN_CREDITLIMIT = new BigDecimal("100");

    private final BigDecimal MIN_RATE = new BigDecimal("0.2");

    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    /**
     *
     */
    public CreditCardAccount(){
        super();
    }

    /**
     *
     * @param creditLimit
     * @param interestRate
     * @param balance
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
     *
     * @return
     */
    @JsonIgnore
    public BigDecimal getMIN_CREDITLIMIT() {
        return MIN_CREDITLIMIT;
    }

    /**
     *
     * @return
     */
    @JsonIgnore
    public BigDecimal getMIN_RATE() {
        return MIN_RATE;
    }

    /**
     *
     * @return
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     *
     * @param creditLimit
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     *
     * @return
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     *
     * @param interestRate
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}