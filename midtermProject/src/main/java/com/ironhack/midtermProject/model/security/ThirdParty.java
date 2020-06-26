/**
 *
 */
package com.ironhack.midtermProject.model.security;

import javax.persistence.Entity;

/**
 *
 */
@Entity
public class ThirdParty extends User{
    private String hashKey;

    /**
     *
     */
    public ThirdParty(){}

    /**
     *
     * @param name
     * @param password
     * @param hashKey
     */
    public ThirdParty(String name, String password, String hashKey) {
        super(name, password);
        this.hashKey = hashKey;
    }

    /**
     *
     * @return
     */
    public String getHashKey() {
        return hashKey;
    }

    /**
     *
     * @param hashKey
     */
    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}