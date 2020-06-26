/**
 *
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
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends AccountKey {
    private final BigDecimal MIN_RATE = new BigDecimal("0.0025");

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    /**
     *
     */
    public SavingsAccount () {
        super();
    }

    /**
     *
     * @param balance
     * @param secretKey
     * @param interestRate
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

    /**
     *
     * @return
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    /**
     *
     * @param minimumBalance
     */
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /**
     *
     * @return
     */
    @JsonIgnore
    public BigDecimal getMIN_RATE() {
        return MIN_RATE;
    }
}
