/**
 * com.ironhack.midtermProject.model.security
 */
package com.ironhack.midtermProject.model.security;

import javax.persistence.Entity;

/**
 * Admin Class.
 */
@Entity
public class Admin extends User {

    /**
     * Default Constructor Admin.
     */
    public Admin(){}

    /**
     * Constructor Admin.
     * @param name name of Admin
     * @param password password of Admin
     */
    public Admin(String name, String password) {
        super(name, password);
    }
}
