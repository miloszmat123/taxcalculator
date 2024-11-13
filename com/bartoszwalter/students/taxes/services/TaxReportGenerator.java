package com.bartoszwalter.students.taxes.services;

public class TaxReportGenerator {

    public static void generateTaxReport(TaxCalculatorService taxCalculatorService) {
        System.out.println("Income: " + taxCalculatorService.getPreTaxIncome());

        System.out.println("Social security tax: "
                + taxCalculatorService.getSocialSecurityFee());

        System.out.println("Health social security tax: "
                + taxCalculatorService.getHealthInsuranceFee());

        System.out.println("Sickness social security tax: "
                + taxCalculatorService.getSicknessInsuranceFee());

        System.out.println("Income basis for health social security: " + taxCalculatorService.getIncomeAfterTax());

        System.out.println("Health social security tax: 9% = "
                + (taxCalculatorService.getCurrentSocialHealthInsuranceFee())
                + " 7,75% = " + taxCalculatorService.getPreviousSocialHealthInsuranceFee());

        System.out.println("Tax deductible expenses: "
                + taxCalculatorService.getTaxDeductibleExpenses());

        System.out.println("Income: " + taxCalculatorService.getTaxedIncome()
                + " rounded: " + taxCalculatorService.getTaxedIncome());

        System.out.println("Advance tax 18%: " + taxCalculatorService.getAdvanceTax());

        System.out.println("Tax free income: " + taxCalculatorService.getTaxFreeIncome());

        System.out.println("Reduced tax: " + taxCalculatorService.getTaxPaid());

        System.out.println("Advance tax paid: " + (taxCalculatorService.getAdvanceTaxPaid())
                + " rounded: " + taxCalculatorService.getAdvanceTaxPaid());

        System.out.println("Net income: " + taxCalculatorService.getNetIncome());
    }
}
