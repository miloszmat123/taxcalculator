package com.bartoszwalter.students.taxes.services;

import com.bartoszwalter.students.taxes.enums.ConstantValues;

import java.math.BigDecimal;

public class EmploymentTaxCalculator extends TaxCalculatorService {
    public EmploymentTaxCalculator(BigDecimal income) {
        super(income);
    }

    @Override
    public BigDecimal getTaxDeductibleExpenses() {
        return ConstantValues.DEDUCTIBLE_EXPENSES_EMPLOYMENT.getValue();
    }

    @Override
    public BigDecimal getTaxFreeIncome() {
        return ConstantValues.TAX_FREE_INCOME.getValue();
    }
}
