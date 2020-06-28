/**
 * com.ironhack.midtermProject.model.entities;
 */
package com.ironhack.midtermProject.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.model.security.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Account Class
 */
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Account {
    private final BigDecimal PENALTYFEE_DEFAULT = new BigDecimal("40");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Embedded
    protected Money balance;

    protected BigDecimal penaltyFee;

    protected LocalDate createdAt;

    protected LocalDate updatedAt;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="primaryowner_id")
    protected User primaryOwner;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="secondaryowner_id")
    protected User secondaryOwner;

    @JsonIgnore
    @OneToMany(mappedBy ="emitteraccount", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Transfer> emitterTranfers;

    @JsonIgnore
    @OneToMany(mappedBy ="receiverAccount", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Transfer> receiverTransfers;

    /**
     * Default Constructor.
     */
    public Account() {
    }

    /**
     * Constructor of Account
     * @param balance balance of Account
     */
    public Account(Money balance) {
        this.balance = balance;
        this.penaltyFee = PENALTYFEE_DEFAULT;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    /**
     * Getter Account Id
     * @return Account Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter Account Id
     * @param id Account Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter balance of Account
     * @return balance of Account
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * Setter balance of Account
     * @param balance balance of Account
     */
    public void setBalance(Money balance) {
        this.balance = balance;
    }

    /**
     * Getter penaltyFee of Account
     * @return penaltyFee of Account
     */
    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    /**
     * Getter Primary Owner of Account
     * @return Primary Owner of Account
     */
    public User getPrimaryOwner() {
        return primaryOwner;
    }

    /**
     * Setter Primary Owner of Account
     * @param primaryOwner Primary Owner of Account
     */
    public void setPrimaryOwner(User primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    /**
     * Getter Secondary Owner of Account
     * @return Secondary Owner of Account
     */
    public User getSecondaryOwner() {
        return secondaryOwner;
    }

    /**
     * Setter Secondary Owner of Account
     * @param secondaryOwner Secondary Owner of Account
     */
    public void setSecondaryOwner(User secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    /**
     * Getter List Transfers Emitter of Account
     * @return List Transfers Emitter of Account
     */
    public List<Transfer> getEmitterTranfers() {
        return emitterTranfers;
    }

    /**
     * Setter List Transfers Emitter of Account
     * @param emitterTranfers List Transfers Emitter of Account
     */
    public void setEmitterTranfers(List<Transfer> emitterTranfers) {
        this.emitterTranfers = emitterTranfers;
    }

    /**
     * Getter List Transfers Receiver of Account
     * @return List Transfers Receiver of Account
     */
    public List<Transfer> getReceiverTransfers() {
        return receiverTransfers;
    }

    /**
     * Setter List Transfers Receiver of Account
     * @param receiverTransfers List Transfers Receiver of Account
     */
    public void setReceiverTransfers(List<Transfer> receiverTransfers) {
        this.receiverTransfers = receiverTransfers;
    }

    /**
     * Getter Penaltyfee default of Account
     * @return Penaltyfee default of Account
     */
    public BigDecimal getPENALTYFEE_DEFAULT() {
        return PENALTYFEE_DEFAULT;
    }

    /**
     * Getter CreatedAt Date
     * @return CreatedAt Date
     */
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter CreatedAt Date
     * @param createdAt CreatedAt Date
     */
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter UpdatedAt Date
     * @return UpdatedAt Date
     */
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter UpdatedAt Date
     * @param updatedAt UpdatedAt Date
     */
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}