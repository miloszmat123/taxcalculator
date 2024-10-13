package com.bartoszwalter.students.taxes;

public class EmploymentTaxCalculator extends TaxCalculatorService {
    public EmploymentTaxCalculator(double income) {
        super(income);
    }

    @Override
    public double getTaxDeductibleExpenses() {

        return super.getTaxDeductibleExpenses();
    }

}