package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CivilTaxCalculator extends TaxCalculatorService {
    public CivilTaxCalculator(BigDecimal income) {
        super(income);
    }

    @Override
    public BigDecimal getTaxDeductibleExpenses() {
        return getPreTaxIncome()
                .multiply(FeePercentValues.DEDUCTIBLE_EXPENSES_CIVIL.getValue())
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }
}
