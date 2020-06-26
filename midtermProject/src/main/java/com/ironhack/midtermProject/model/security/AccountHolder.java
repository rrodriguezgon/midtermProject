/**
 *
 */
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

/**
 *
 */
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

    /**
     *
     */
    public AccountHolder(){}

    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param birthday
     * @param primaryAddress
     * @param mailingAddress
     */
    public AccountHolder(String username, String password, String firstName, String lastName,
                         LocalDate birthday, Address primaryAddress, String mailingAddress) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    /**
     *
     * @return
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return
     */
    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     *
     * @param primaryAddress
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     *
     * @return
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     *
     * @param mailingAddress
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    /**
     *
     * @return
     */
    public List<Account> getAccountsPrimary() {
        return accountsPrimary;
    }

    /**
     *
     * @param accountsPrimary
     */
    public void setAccountsPrimary(List<Account> accountsPrimary) {
        this.accountsPrimary = accountsPrimary;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getFirstAndLastnName(){
        return this.firstName + " " + this.lastName;
    }

    /**
     *
     * @return
     */
    public List<Account> getAccountsSecondary() {
        return accountsSecondary;
    }

    /**
     *
     * @param accountsSecondary
     */
    public void setAccountsSecondary(List<Account> accountsSecondary) {
        this.accountsSecondary = accountsSecondary;
    }
}