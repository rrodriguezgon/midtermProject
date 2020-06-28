/**
 * com.ironhack.midtermProject.model.security
 */
package com.ironhack.midtermProject.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Role Class.
 */
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;

    @ManyToOne
    @JsonIgnore
    private User user;

    /**
     * Default Constructor Role
     */
    public Role() {}

    /**
     * Constructor Role
     * @param role A String value
     */
    public Role(String role) {
        this.role = role;
    }

    /**
     * This method gets Role's id
     * @return a integer value
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets Role's id
     * @param id a long value
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *  This method gets Role's role
     * @return a Role element
     */
    public String getRole() {
        return role;
    }

    /**
     * This method sets Role's role
     * @param role A String value
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * This method gets Role's user
     * @return a User element
     */
    public User getUser() {
        return user;
    }

    /**
     * This method sets Role's user
     * @param user a User element
     */
    public void setUser(User user) {
        this.user = user;
    }
}
