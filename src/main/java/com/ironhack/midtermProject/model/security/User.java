/**
 * com.ironhack.midtermProject.model.security
 */
package com.ironhack.midtermProject.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.entities.Transfer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User Class.
 */
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String username;
    protected String password;

    @JsonIgnore
    @OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy="user")
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy ="emitterUser", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Transfer> transfersMade;

    /**
     * Default Constructor User.
     */
    public User(){}

    /**
     * Constructor User.
     * @param username username of User
     * @param password password of User.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter Id of User.
     * @return Id of User.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter If of User.
     * @param id Id of User.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter username of User.
     * @return username of User
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter username of User
     * @param username username of User
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password of User
     * @return password of User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password of User
     * @param password password of User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter roles of User
     * @return roles of User
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Setter roles of User
     * @param roles roles of User
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
