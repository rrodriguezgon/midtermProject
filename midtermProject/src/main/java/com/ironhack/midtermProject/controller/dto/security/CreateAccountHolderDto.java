/**
 *
 */
package com.ironhack.midtermProject.controller.dto.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ironhack.midtermProject.model.security.Address;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 *
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
     *
     */
    public CreateAccountHolderDto(){}

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
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
}