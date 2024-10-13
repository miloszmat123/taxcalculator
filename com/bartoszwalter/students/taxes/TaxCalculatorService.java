package com.bartoszwalter.students.taxes;

public class TaxCalculatorService {
    private double preTaxIncome;


    public TaxCalculatorService(double preTaxIncome) {
        this.preTaxIncome = preTaxIncome;
    }

    public double getSocialSecurityFee() {
        return (preTaxIncome * FeePercentValues.SOCIAL_SECURITY.getPercentage()) / 100;
    }

    public double getHealthInsuranceFee() {
        return (preTaxIncome * FeePercentValues.HEALTH_INSURANCE.getPercentage()) / 100;
    }

    public double getSicknessInsuranceFee() {
        return (preTaxIncome * FeePercentValues.SICKNESS_INSURANCE.getPercentage()) / 100;
    }

    public double getCurrentSocialHealthInsuranceFee() {
        return (preTaxIncome * FeePercentValues.CURRENT_SOCIAL_HEALTH_INSURANCE.getPercentage()) / 100;
    }

    public double getPreviousSocialHealthInsuranceFee() {
        return (preTaxIncome * FeePercentValues.PREVIOUS_SOCIAL_HEALTH_INSURANCE.getPercentage()) / 100;
    }

    public double getTaxFreeIncome() {
        return 0;
    } //no taxFreeIncome info in previous code

    public double getTaxDeductibleExpenses() {
        return 0;
    }

    public double getAdvanceTax() {
        return (preTaxIncome * FeePercentValues.ADVANCE_TAX.getPercentage()) / 100;
    }

    public double getAdvanceTaxPaid() {
        return getPreviousSocialHealthInsuranceFee() - getTaxFreeIncome();
    }

    public double getNetIncome() {
        return preTaxIncome - ((getSocialSecurityFee() + getHealthInsuranceFee() + getSicknessInsuranceFee())
                + getCurrentSocialHealthInsuranceFee() + getAdvanceTaxPaid());
    }

    public double getIncomeAfterTax() {
        return (preTaxIncome - getSocialSecurityFee() - getHealthInsuranceFee() - getSicknessInsuranceFee());
    }

    public double getTaxedIncome() {
        return preTaxIncome - getTaxDeductibleExpenses();
    }

    public double getTaxPaid() {
        return getAdvanceTax() - getTaxFreeIncome();
    }

    public double getPreTaxIncome() {
        return preTaxIncome;
    }


}
