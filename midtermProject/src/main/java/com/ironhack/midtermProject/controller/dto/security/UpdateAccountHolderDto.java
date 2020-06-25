package com.ironhack.midtermProject.controller.dto.security;

import com.ironhack.midtermProject.model.security.Address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UpdateAccountHolderDto {

    @NotEmpty(message = "firstName cannot be empty")
    String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    String lastName;

    @Past(message = "You must indicate an earlier date than the current one")
    LocalDate birthday;

    @NotNull(message = "PrimaryAddress cannot be null")
    Address primaryAddress;

    String mailingAddress;

    public UpdateAccountHolderDto(){}

    public UpdateAccountHolderDto(String firstName, String lastName,
                                  LocalDate birthday, Address primaryAddress, String mailingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
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

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}