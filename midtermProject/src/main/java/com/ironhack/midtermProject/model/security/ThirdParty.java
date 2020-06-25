package com.ironhack.midtermProject.model.security;

import com.ironhack.midtermProject.model.entities.Account;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class ThirdParty extends User{
    private String hashKey;

    public ThirdParty(){}

    public ThirdParty(String name, String password, String hashKey) {
        super(name, password);
        this.hashKey = hashKey;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}