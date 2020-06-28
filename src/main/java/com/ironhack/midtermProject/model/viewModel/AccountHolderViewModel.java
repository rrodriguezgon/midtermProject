package com.ironhack.midtermProject.model.viewModel;

import com.ironhack.midtermProject.model.security.Address;

import java.time.LocalDate;

public class AccountHolderViewModel extends UserViewModel {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address primaryAddress;
    private String accountsPrimary;
    private String accountsSecondary;
    private String mailingAddress;

    public AccountHolderViewModel(Integer id, String username, String password, String roles, String firstName, String lastName, LocalDate birthday, Address primaryAddress, String accountsPrimary, String accountsSecondary, String mailingAddress) {
        super(id, username, password, roles);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.accountsPrimary = accountsPrimary;
        this.accountsSecondary = accountsSecondary;
        this.mailingAddress = mailingAddress;
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

    public String getAccountsPrimary() {
        return accountsPrimary;
    }

    public void setAccountsPrimary(String accountsPrimary) {
        this.accountsPrimary = accountsPrimary;
    }

    public String getAccountsSecondary() {
        return accountsSecondary;
    }

    public void setAccountsSecondary(String accountsSecondary) {
        this.accountsSecondary = accountsSecondary;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
