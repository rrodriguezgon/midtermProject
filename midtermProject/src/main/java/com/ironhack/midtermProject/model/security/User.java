/**
 *
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
 *
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
     *
     */
    public User(){}

    /**
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
