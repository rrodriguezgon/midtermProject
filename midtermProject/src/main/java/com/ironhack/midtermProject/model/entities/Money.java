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
     *
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
     *
     * @param money
     * @return
     */
    public BigDecimal increaseAmount(Money money) {
        setAmount(this.amount.add(money.amount));
        return this.amount;
    }

    /**
     *
     * @param addAmount
     * @return
     */
    public BigDecimal increaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.add(addAmount));
        return this.amount;
    }

    /**
     *
     * @param money
     * @return
     */
    public BigDecimal decreaseAmount(Money money) {
        setAmount(this.amount.subtract(money.getAmount()));
        return this.amount;
    }

    /**
     *
     * @param addAmount
     * @return
     */
    public BigDecimal decreaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.subtract(addAmount));
        return this.amount;
    }

    /**
     *
     * @return
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     *
     * @return
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     *
     * @param amount
     */
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return getCurrency().getSymbol() + " " + getAmount();
    }
}
