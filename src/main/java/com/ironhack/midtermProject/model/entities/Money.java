/**
 *
 */
package com.ironhack.midtermProject.model.entities;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 */
public class Money implements Transactional{
    private static final Currency USD = Currency.getInstance("USD");
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
    private final Currency currency;
    private BigDecimal amount;

    /**
     * Default constructor Money
     */
    public Money(){
        this.currency = Currency.getInstance("USD");
    }

    /**
     * Class constructor specifying amount, currency, and rounding
     **/
    public Money(BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.currency = currency;
        setAmount(amount.setScale(currency.getDefaultFractionDigits(), rounding));
    }
    /**
     * Class constructor specifying amount, and currency. Uses default RoundingMode HALF_EVEN.
     **/
    public Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }
    /**
     * Class constructor specifying amount. Uses default RoundingMode HALF_EVEN and default currency USD.
     **/
    public Money(BigDecimal amount) {
        this(amount, USD, DEFAULT_ROUNDING);
    }

    /**
     * Setter increaseAmount of Money.
     * @param money increaseAmount of Money.
     * @return Amount of Money.
     */
    public BigDecimal increaseAmount(Money money) {
        setAmount(this.amount.add(money.amount));
        return this.amount;
    }

    /**
     * Setter increaseAmount Money.
     * @param addAmount increaseAmount Money.
     * @return Amount of Money
     */
    public BigDecimal increaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.add(addAmount));
        return this.amount;
    }

    /**
     * Setter decreaseAmount of Money
     * @param money decreaseAmount of Money
     * @return Amount of Money
     */
    public BigDecimal decreaseAmount(Money money) {
        setAmount(this.amount.subtract(money.getAmount()));
        return this.amount;
    }

    /**
     * Setter decreaseAmount of Money
     * @param addAmount decreaseAmount of Money
     * @return Amount of Money
     */
    public BigDecimal decreaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.subtract(addAmount));
        return this.amount;
    }

    /**
     * Getter Currency of Money
     * @return Currency of Money
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Getter Amount of Money
     * @return Amount of Money
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Setter Amount of Money
     * @param amount Amount of Money
     */
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * tostring Money Class.
     * @return Info Money Class.
     */
    public String toString() {
        return getCurrency().getSymbol() + " " + getAmount();
    }
}
