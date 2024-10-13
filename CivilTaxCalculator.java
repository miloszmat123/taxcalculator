package com.bartoszwalter.students.taxes;

public class CivilTaxCalculator extends TaxCalculatorService {
    public CivilTaxCalculator(double income) {
        super(income);
    }

    @Override
    public double getTaxDeductibleExpenses() {

        return (getPreTaxIncome() * FeePercentValues.DEDUCTABLE_EXPENSES.getPercentage()) / 100;
    }

}
