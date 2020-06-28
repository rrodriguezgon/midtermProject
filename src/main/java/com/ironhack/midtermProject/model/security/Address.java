/**
 * com.ironhack.midtermProject.model.security
 */
package com.ironhack.midtermProject.model.security;

import javax.validation.constraints.NotEmpty;

/**
 * Address Class.
 */
public class Address {
    @NotEmpty(message = "Number cannot be empty")
    private String number;

    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @NotEmpty(message = "City cannot be empty")
    private String city;

    @NotEmpty(message = "Country cannot be empty")
    private String country;

    /**
     * Default Constructor Address.
     */
    public Address(){}

    /**
     * Constructor Address.
     * @param number number of address.
     * @param street street of address.
     * @param city city of address.
     * @param country country of address.
     */
    public Address(String number, String street, String city, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    /**
     * number of address.
     * @return number of address.
     */
    public String getNumber() {
        return number;
    }

    /**
     * number of address.
     * @param number number of address.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * street of address.
     * @return street of address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * street of address.
     * @param street street of address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * city of address.
     * @return city of address.
     */
    public String getCity() {
        return city;
    }

    /**
     * city of address.
     * @param city city of address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * country of address.
     * @return country of address.
     */
    public String getCountry() {
        return country;
    }

    /**
     * country of address.
     * @param country country of address.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
