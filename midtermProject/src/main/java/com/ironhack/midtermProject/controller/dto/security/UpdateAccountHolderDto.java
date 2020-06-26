/**
 * com.ironhack.midtermProject.controller.dto.security
 */
package com.ironhack.midtermProject.controller.dto.security;

import com.ironhack.midtermProject.model.security.Address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 *
 */
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

    /**
     *
      */
    public UpdateAccountHolderDto(){}

    /**
     *
     * @param firstName
     * @param lastName
     * @param birthday
     * @param primaryAddress
     * @param mailingAddress
     */
    public UpdateAccountHolderDto(String firstName, String lastName,
                                  LocalDate birthday, Address primaryAddress, String mailingAddress) {
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