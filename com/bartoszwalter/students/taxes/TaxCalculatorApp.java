package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;

class TaxCalculatorApp {

    public static void main(String[] args) {
        char contractType;
        BigDecimal income;

        income = readIncome();
        contractType = readContractType();

        if (contractType == 'E') {
            System.out.println("Income: " + income);
            EmploymentTaxCalculator employmentTaxCalculator = new EmploymentTaxCalculator(income);

            printTaxInformation(employmentTaxCalculator);
        } else if (contractType == 'C') {
            System.out.println("Income: " + income);
            CivilTaxCalculator civilTaxCalculator = new CivilTaxCalculator(income);

            printTaxInformation(civilTaxCalculator);
        } else {
            System.out.println("Unknown type of contract!");
        }
    }

    public static BigDecimal readIncome() {
        BigDecimal income = BigDecimal.ZERO;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Enter income: ");
            income = new BigDecimal(br.readLine());

        } catch (IOException ex) {
            System.out.println("Incorrect");
            System.err.println(ex);
        }
        return income;
    }

    public static char readContractType() {
        char contractType = ' ';
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = br.readLine().charAt(0);

        } catch (IOException ex) {
            System.out.println("Incorrect");
            System.err.println(ex);
        }
        return contractType;
    }

    public static void printTaxInformation(TaxCalculatorService taxCalculatorService) {
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

