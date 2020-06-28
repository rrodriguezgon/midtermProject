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
 * UpdateAccountHolderDto Class
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
     * Default Constructor UpdateAccountHolderDto.
      */
    public UpdateAccountHolderDto(){}

    /**
     * Constructor UpdateAccountHolderDto
     * @param firstName firstName of Account Holder
     * @param lastName lastName of Account Holder
     * @param birthday birthday of Account Holder
     * @param primaryAddress primaryAddress of Account Holder
     * @param mailingAddress mailingAddress of Account Holder
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