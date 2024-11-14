package com.bartoszwalter.students.taxes.services;

import com.bartoszwalter.students.taxes.enums.ConstantValues;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CivilTaxCalculator extends TaxCalculatorService {
    public CivilTaxCalculator(BigDecimal income) {
        super(income);
    }

    @Override
    public BigDecimal getTaxDeductibleExpenses() {
        return getPreTaxIncome()
                .multiply(ConstantValues.DEDUCTIBLE_EXPENSES_CIVIL.getValue())
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }
}
