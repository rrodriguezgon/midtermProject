/**
 *
 */
package com.ironhack.midtermProject.model.security;

import javax.validation.constraints.NotEmpty;

/**
 *
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
     *
     */
    public Address(){}

    /**
     *
     * @param number
     * @param street
     * @param city
     * @param country
     */
    public Address(String number, String street, String city, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
