package com.ironhack.midtermProject.controller.dto.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ironhack.midtermProject.model.security.Address;

import javax.validation.constraints.*;
import java.time.LocalDate;

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

    public CreateAccountHolderDto(){}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}