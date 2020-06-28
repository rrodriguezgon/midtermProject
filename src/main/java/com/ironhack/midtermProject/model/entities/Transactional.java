/**
 * com.ironhack.midtermProject.model.entities
 */
package com.ironhack.midtermProject.model.entities;

import java.math.BigDecimal;

/**
 * Transactional Interface.
 */
interface Transactional {

    /**
     * increaseAmount
     * @param addAmount Amount increase of Transactional
     * @return Amount of Transactional.
     */
    BigDecimal increaseAmount(BigDecimal addAmount);

    /**
     * decreaseAmount
     * @param addAmount addAmount Amount decrease of Transactional
     * @return Amount of Transactional.
     */
    BigDecimal decreaseAmount(BigDecimal addAmount);

    /**
     * tostring Money Class.
     * @return Info Money Class.
     */
    String toString();
}
