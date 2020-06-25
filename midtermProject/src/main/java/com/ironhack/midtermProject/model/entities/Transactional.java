package com.ironhack.midtermProject.model.entities;

import java.math.BigDecimal;
interface Transactional {
    BigDecimal increaseAmount(BigDecimal addAmount);
    BigDecimal decreaseAmount(BigDecimal addAmount);
    String toString();
}
