/**
 * com.ironhack.midtermProject.model.security
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
 * AccountHolder Class.
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
     * Default Constructor AccountHolder.
     */
    public AccountHolder(){}

    /**
     * Constructor AccountHolder.
     * @param username username of AccountHolder
     * @param password password of AccountHolder
     * @param firstName firstName of AccountHolder
     * @param lastName lastName of AccountHolder
     * @param birthday birthday of AccountHolder
     * @param primaryAddress primaryAddress of AccountHolder
     * @param mailingAddress mailingAddress of AccountHolder
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
     * Getter birthday of AccountHolder
     * @return birthday of AccountHolder
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Setter birthday of AccountHolder
     * @param birthday birthday of AccountHolder
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Getter primaryAddress of AccountHolder
     * @return primaryAddress of AccountHolder
     */
    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * Setter primaryAddress of AccountHolder
     * @param primaryAddress primaryAddress of AccountHolder
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     * Getter mailingAddress of AccountHolder
     * @return mailingAddress of AccountHolder
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Setter mailingAddress of AccountHolder
     * @param mailingAddress mailingAddress of AccountHolder
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    /**
     * Getter accountsPrimary of AccountHolder
     * @return accountsPrimary of AccountHolder
     */
    public List<Account> getAccountsPrimary() {
        return accountsPrimary;
    }

    /**
     * Setter accountsPrimary of AccountHolder
     * @param accountsPrimary accountsPrimary of AccountHolder
     */
    public void setAccountsPrimary(List<Account> accountsPrimary) {
        this.accountsPrimary = accountsPrimary;
    }

    /**
     * Getter firstName of AccountHolder
     * @return firstName of AccountHolder
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter firstName of AccountHolder
     * @param firstName firstName of AccountHolder
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter lastName of AccountHolder
     * @return lastName of AccountHolder
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter lastName of AccountHolder
     * @param lastName lastName of AccountHolder
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter firstName with lastName of AccountHolder
     * @return firstName with lastName of AccountHolder
     */
    public String getFirstAndLastnName(){
        return this.firstName + " " + this.lastName;
    }

    /**
     * Getter accountsSecondary of AccountHolder
     * @return accountsSecondary of AccountHolder
     */
    public List<Account> getAccountsSecondary() {
        return accountsSecondary;
    }

    /**
     * Setter accountsSecondary of AccountHolder
     * @param accountsSecondary accountsSecondary of AccountHolder
     */
    public void setAccountsSecondary(List<Account> accountsSecondary) {
        this.accountsSecondary = accountsSecondary;
    }
}