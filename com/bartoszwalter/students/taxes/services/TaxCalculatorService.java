package com.bartoszwalter.students.taxes.services;

import com.bartoszwalter.students.taxes.enums.ConstantValues;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorService {
    private BigDecimal preTaxIncome;

    public TaxCalculatorService(BigDecimal preTaxIncome) {
        this.preTaxIncome = preTaxIncome;
    }

    public BigDecimal getSocialSecurityFee() {
        return preTaxIncome.multiply(ConstantValues.SOCIAL_SECURITY.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getHealthInsuranceFee() {
        return preTaxIncome.multiply(ConstantValues.HEALTH_INSURANCE.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getSicknessInsuranceFee() {
        return preTaxIncome.multiply(ConstantValues.SICKNESS_INSURANCE.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getCurrentSocialHealthInsuranceFee() {
        return preTaxIncome.multiply(ConstantValues.CURRENT_SOCIAL_HEALTH_INSURANCE.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getPreviousSocialHealthInsuranceFee() {
        return preTaxIncome.multiply(ConstantValues.PREVIOUS_SOCIAL_HEALTH_INSURANCE.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getTaxFreeIncome() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getTaxDeductibleExpenses() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getAdvanceTax() {
        return preTaxIncome.multiply(ConstantValues.ADVANCE_TAX.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public BigDecimal getAdvanceTaxPaid() {
        return getPreviousSocialHealthInsuranceFee().subtract(getTaxFreeIncome());
    }

    public BigDecimal getNetIncome() {
        BigDecimal totalDeductions = getSocialSecurityFee()
                .add(getHealthInsuranceFee())
                .add(getSicknessInsuranceFee())
                .add(getCurrentSocialHealthInsuranceFee())
                .add(getAdvanceTaxPaid());
        return preTaxIncome.subtract(totalDeductions);
    }

    public BigDecimal getIncomeAfterTax() {
        return preTaxIncome.subtract(getSocialSecurityFee())
                .subtract(getHealthInsuranceFee())
                .subtract(getSicknessInsuranceFee());
    }

    public BigDecimal getTaxedIncome() {
        return preTaxIncome.subtract(getTaxDeductibleExpenses());
    }

    public BigDecimal getTaxPaid() {
        return getAdvanceTax().subtract(getTaxFreeIncome());
    }

    public BigDecimal getPreTaxIncome() {
        return preTaxIncome;
    }
}
