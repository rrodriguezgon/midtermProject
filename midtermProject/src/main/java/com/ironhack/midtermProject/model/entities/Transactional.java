/**
 *
 */
package com.ironhack.midtermProject.model.entities;

import java.math.BigDecimal;

/**
 *
 */
interface Transactional {

    /**
     *
     * @param addAmount
     * @return
     */
    BigDecimal increaseAmount(BigDecimal addAmount);

    /**
     *
     * @param addAmount
     * @return
     */
    BigDecimal decreaseAmount(BigDecimal addAmount);

    /**
     *
     * @return
     */
    String toString();
}
