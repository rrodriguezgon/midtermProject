/**
 *
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
 *
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
     *
     */
    public Account() {
    }

    /**
     *
     * @param balance
     */
    public Account(Money balance) {
        this.balance = balance;
        this.penaltyFee = PENALTYFEE_DEFAULT;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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
    public Money getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(Money balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    /**
     *
     * @param penaltyFee
     */
    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    /**
     *
     * @return
     */
    public User getPrimaryOwner() {
        return primaryOwner;
    }

    /**
     *
     * @param primaryOwner
     */
    public void setPrimaryOwner(User primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    /**
     *
     * @return
     */
    public User getSecondaryOwner() {
        return secondaryOwner;
    }

    /**
     *
     * @param secondaryOwner
     */
    public void setSecondaryOwner(User secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    /**
     *
     * @return
     */
    public List<Transfer> getEmitterTranfers() {
        return emitterTranfers;
    }

    /**
     *
     * @param emitterTranfers
     */
    public void setEmitterTranfers(List<Transfer> emitterTranfers) {
        this.emitterTranfers = emitterTranfers;
    }

    /**
     *
     * @return
     */
    public List<Transfer> getReceiverTransfers() {
        return receiverTransfers;
    }

    /**
     *
     * @param receiverTransfers
     */
    public void setReceiverTransfers(List<Transfer> receiverTransfers) {
        this.receiverTransfers = receiverTransfers;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPENALTYFEE_DEFAULT() {
        return PENALTYFEE_DEFAULT;
    }

    /**
     *
     * @return
     */
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     */
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     */
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     */
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}