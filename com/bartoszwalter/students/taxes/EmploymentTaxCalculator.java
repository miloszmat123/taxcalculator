package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

public class EmploymentTaxCalculator extends TaxCalculatorService {
    public EmploymentTaxCalculator(BigDecimal income) {
        super(income);
    }

    @Override
    public BigDecimal getTaxDeductibleExpenses() {
        return FeePercentValues.DEDUCTIBLE_EXPENSES_EMPLOYMENT.getValue();
    }

    @Override
    public BigDecimal getTaxFreeIncome() {
        return FeePercentValues.TAX_FREE_INCOME.getValue();
    }
}
