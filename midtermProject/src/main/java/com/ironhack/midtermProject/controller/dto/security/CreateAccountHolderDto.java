/**
 * com.ironhack.midtermProject.controller.dto.security
 */
package com.ironhack.midtermProject.controller.dto.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ironhack.midtermProject.model.security.Address;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * CreateAccountHolderDto Class
 */
public class CreateAccountHolderDto {

    @NotEmpty(message = "username cannot be empty")
    String username;

    @NotEmpty(message = "Password cannot be empty")
    String password;

    @NotEmpty(message = "firstName cannot be empty")
    String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    String lastName;

    @Past(message = "You must indicate an earlier date than the current one")
    @JsonSerialize(using = ToStringSerializer.class)
    LocalDate birthday;

    @NotNull(message = "PrimaryAddress cannot be null")
    Address primaryAddress;

    String mailingAddress;

    /**
     * Default Constructor CreateAccountHolderDto.
     */
    public CreateAccountHolderDto(){}

    /**
     * Constructor CreateAccountHolderDto.
     * @param username username of Account Holder
     * @param password password of Account Holder
     * @param firstName firstName of Account Holder
     * @param lastName lastName of Account Holder
     * @param birthday birthday of Account Holder
     * @param primaryAddress primaryAddress of Account Holder
     * @param mailingAddress mailingAddress of Account Holder
     */
    public CreateAccountHolderDto(String username, String password, String firstName, String lastName,
                                  LocalDate birthday, Address primaryAddress, String mailingAddress) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    /**
     * Getter username of Account Holder
     * @return username of Account Holder
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter username of Account Holder
     * @param username username of Account Holder
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password of Account Holder
     * @return password of Account Holder
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password of Account Holder
     * @param password password of Account Holder
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter firstName of Account Holder
     * @return firstName of Account Holder
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter firstName of Account Holder
     * @param firstName firstName of Account Holder
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter lastName of Account Holder
     * @return lastName of Account Holder
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter lastName of Account Holder
     * @param lastName lastName of Account Holder
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter birthday of Account Holder
     * @return birthday of Account Holder
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Setter birthday of Account Holder
     * @param birthday birthday of Account Holder
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Getter primaryAddress of Account Holder
     * @return primaryAddress of Account Holder
     */
    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * Setter primaryAddress of Account Holder
     * @param primaryAddress primaryAddress of Account Holder
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     * Getter mailingAddress of Account Holder
     * @return mailingAddress of Account Holder
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Setter mailingAddress of Account Holder
     * @param mailingAddress mailingAddress of Account Holder
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}