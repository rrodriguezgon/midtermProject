package com.ironhack.midtermProject.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.entities.Account;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountHolder extends User {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @Embedded
    private Address primaryAddress;
    private String mailingAddress;

    @JsonIgnore
    @OneToMany(mappedBy ="primaryOwner", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Account> accountsPrimary;

    @JsonIgnore
    @OneToMany(mappedBy ="secondaryOwner", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Account> accountsSecondary;

    public AccountHolder(){}

    public AccountHolder(String username, String password, String firstName, String lastName,
                         LocalDate birthday, Address primaryAddress, String mailingAddress) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getAccountsPrimary() {
        return accountsPrimary;
    }

    public void setAccountsPrimary(List<Account> accountsPrimary) {
        this.accountsPrimary = accountsPrimary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstAndLastnName(){
        return this.firstName + " " + this.lastName;
    }

    public List<Account> getAccountsSecondary() {
        return accountsSecondary;
    }

    public void setAccountsSecondary(List<Account> accountsSecondary) {
        this.accountsSecondary = accountsSecondary;
    }
}