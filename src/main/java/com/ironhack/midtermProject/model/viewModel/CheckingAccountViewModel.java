package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CheckingAccountViewModel extends AccountKeyViewModel {
    private BigDecimal minimumBalance;
    private int monthlyMaintenanceFee;

    public CheckingAccountViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner, String secretKey, StatusAccount status, BigDecimal minimumBalance, int monthlyMaintenanceFee) {
        super(id, balance, penaltyFee, createdAt, updatedAt, namePrimaryOwner, nameSecondaryOwner, secretKey, status);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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
}
