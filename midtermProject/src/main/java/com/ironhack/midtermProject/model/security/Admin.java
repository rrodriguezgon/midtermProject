/**
 *
 */
package com.ironhack.midtermProject.model.security;

import javax.persistence.Entity;

/**
 *
 */
@Entity
public class Admin extends User {

    /**
     *
     */
    public Admin(){}

    /**
     *
     * @param name
     * @param password
     */
    public Admin(String name, String password) {
        super(name, password);
    }
}
