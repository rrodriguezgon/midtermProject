package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.entities.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class AccountKeyViewModel extends AccountViewModel {
    protected String secretKey;
    protected StatusAccount status;

    public AccountKeyViewModel(Integer id, Money balance, BigDecimal penaltyFee, LocalDate createdAt, LocalDate updatedAt, String namePrimaryOwner, String nameSecondaryOwner, String secretKey, StatusAccount status) {
        super(id, balance, penaltyFee, createdAt, updatedAt, namePrimaryOwner, nameSecondaryOwner);
        this.secretKey = secretKey;
        this.status = status;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public StatusAccount getStatus() {
        return status;
    }

    public void setStatus(StatusAccount status) {
        this.status = status;
    }
}
