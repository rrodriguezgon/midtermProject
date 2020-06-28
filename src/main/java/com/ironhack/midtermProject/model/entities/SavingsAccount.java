/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * SavingsAccount Class.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends AccountKey {
    private final BigDecimal MIN_RATE = new BigDecimal("0.0025");

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    /**
     * Default Constructor SavingsAccount.
     */
    public SavingsAccount () {
        super();
    }

    /**
     * Constructor SavingsAccount.
     * @param balance balance of SavingsAccount.
     * @param secretKey secretkey of SavingsAccount.
     * @param interestRate interestRate of SavingsAccount.
     */
    public SavingsAccount(Money balance, String secretKey, BigDecimal interestRate) {
        super(balance,secretKey);
        if (interestRate != null){
            this.interestRate = interestRate;
        } else {
            this.interestRate = MIN_RATE;
        }

        this.minimumBalance = new BigDecimal("1000");
    }

    /**
     * Getter interestRate of CreditCardAccount
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

    /**
     * Getter minimumBalance of CreditCardAccount
     * @return minimumBalance of CreditCardAccount
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Setter minimumBalance of CreditCardAccount
     * @param minimumBalance minimumBalance of CreditCardAccount
     */
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /**
     * Getter MIN_RATE of CreditCardAccount
     * @return MIN_RATE of CreditCardAccount
     */
    @JsonIgnore
    public BigDecimal getMIN_RATE() {
        return MIN_RATE;
    }
}
