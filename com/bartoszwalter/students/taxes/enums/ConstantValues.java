package com.bartoszwalter.students.taxes.enums;

import java.math.BigDecimal;

public enum ConstantValues {
    SOCIAL_SECURITY(9.76),
    HEALTH_INSURANCE(1.5),
    SICKNESS_INSURANCE(2.45),
    CURRENT_SOCIAL_HEALTH_INSURANCE(9),
    PREVIOUS_SOCIAL_HEALTH_INSURANCE(7.75),
    ADVANCE_TAX(18),
    DEDUCTIBLE_EXPENSES_CIVIL(20),
    DEDUCTIBLE_EXPENSES_EMPLOYMENT(111.25),
    TAX_FREE_INCOME(46.33);

    private final BigDecimal value;

    ConstantValues(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
