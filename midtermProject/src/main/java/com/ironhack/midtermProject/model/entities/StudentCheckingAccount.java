package com.ironhack.midtermProject.model.entities;

import com.ironhack.midtermProject.enums.StatusAccount;
import com.ironhack.midtermProject.model.security.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class StudentCheckingAccount extends AccountKey {

    public StudentCheckingAccount(){
        super();
    }

    public StudentCheckingAccount(Money balance, String secretKey) {
        super(balance,secretKey);
        this.setBalance(balance);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}