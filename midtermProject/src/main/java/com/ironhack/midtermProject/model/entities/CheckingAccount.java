package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CheckingAccount extends AccountKey {

    private final BigDecimal MINIMUM_BALANCE_DEFAULT = new BigDecimal("250");
    private final int MONTLYMAINTENANCEFEE_DEFAULT = 12;

    private BigDecimal minimumBalance;
    private int monthlyMaintenanceFee;

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(Money balance,
                           String secretKey) {
        super(balance,secretKey);
        this.minimumBalance = MINIMUM_BALANCE_DEFAULT;
        this.monthlyMaintenanceFee = MONTLYMAINTENANCEFEE_DEFAULT;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    public int getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(int monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
    public BigDecimal getMINIMUM_BALANCE_DEFAULT() {
        return MINIMUM_BALANCE_DEFAULT;
    }

    public int getMONTLYMAINTENANCEFEE_DEFAULT() {
        return MONTLYMAINTENANCEFEE_DEFAULT;
    }
}