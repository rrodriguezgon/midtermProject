/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * CheckingAccount Class.
 */
@Entity
public class CheckingAccount extends AccountKey {

    private final BigDecimal MINIMUM_BALANCE_DEFAULT = new BigDecimal("250");
    private final int MONTLYMAINTENANCEFEE_DEFAULT = 12;

    private BigDecimal minimumBalance;
    private int monthlyMaintenanceFee;

    /**
     * Default Constructor CheckingAccount.
     */
    public CheckingAccount(){
        super();
    }

    /**
     * Constructor CheckingAccount.
     * @param balance balance of CheckingAccount.
     * @param secretKey secretkey of Account Key.
     */
    public CheckingAccount(Money balance,
                           String secretKey) {
        super(balance,secretKey);
        this.minimumBalance = MINIMUM_BALANCE_DEFAULT;
        this.monthlyMaintenanceFee = MONTLYMAINTENANCEFEE_DEFAULT;
    }

    /**
     * Getter MinimumBalance of CheckingAccount.
     * @return MinimumBalance of CheckingAccount.
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Getter monthlyMaintenanceFee of CheckingAccount.
     * @return monthlyMaintenanceFee of CheckingAccount.
     */
    public int getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    /**
     * Getter MINIMUM_BALANCE_DEFAULT of CheckingAccount.
     * @return MINIMUM_BALANCE_DEFAULT of CheckingAccount.
     */
    public BigDecimal getMINIMUM_BALANCE_DEFAULT() {
        return MINIMUM_BALANCE_DEFAULT;
    }

    /**
     * Getter MONTLYMAINTENANCEFEE_DEFAULT of CheckingAccount.
     * @return MONTLYMAINTENANCEFEE_DEFAULT of CheckingAccount.
     */
    public int getMONTLYMAINTENANCEFEE_DEFAULT() {
        return MONTLYMAINTENANCEFEE_DEFAULT;
    }
}