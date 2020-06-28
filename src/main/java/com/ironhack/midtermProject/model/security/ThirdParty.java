/**
 * com.ironhack.midtermProject.model.security
 */
package com.ironhack.midtermProject.model.security;

import javax.persistence.Entity;

/**
 * ThirdParty Class.
 */
@Entity
public class ThirdParty extends User{
    private String hashKey;

    /**
     * Default Constructor ThirdParty
     */
    public ThirdParty(){}

    /**
     * Constructor ThirdParty.
     * @param username username of ThirdParty
     * @param password password of ThirdParty
     * @param hashKey hashKey of ThirdParty
     */
    public ThirdParty(String username, String password, String hashKey) {
        super(username, password);
        this.hashKey = hashKey;
    }

    /**
     * Getter hashKey of ThirdParty
     * @return hashKey of ThirdParty
     */
    public String getHashKey() {
        return hashKey;
    }

    /**
     * Setter hashKey of ThirdParty
     * @param hashKey hashKey of ThirdParty
     */
    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}