package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class TaxCalculatorApp {
    private static final DecimalFormat twoDecimalFormat = new DecimalFormat("0.00");
    private static final DecimalFormat noDecimalFormat = new DecimalFormat("#");

    public static void main(String[] args) {
        char contractType;
        double income;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.print("Enter income: ");
            income = Double.parseDouble(bufferedReader.readLine());

            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = bufferedReader.readLine().charAt(0);

        } catch (IOException | NumberFormatException ex)
        {
            System.out.println("Incorrect input data! Error: " + ex);
            return;
        }

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

    public static void printTaxInformation(TaxCalculatorService taxCalculatorService) {
        System.out.println("Social security tax: "
				+ twoDecimalFormat.format(taxCalculatorService.getSocialSecurityFee()));

        System.out.println("Health social security tax: "
				+ twoDecimalFormat.format(taxCalculatorService.getHealthInsuranceFee()));

        System.out.println("Sickness social security tax: "
				+ twoDecimalFormat.format(taxCalculatorService.getSicknessInsuranceFee()));

        System.out.println("Income basis for health social security: "+ taxCalculatorService.getIncomeAfterTax());

        System.out.println("Health social security tax: 9% = "
				+ twoDecimalFormat.format(taxCalculatorService.getCurrentSocialHealthInsuranceFee())
				+ " 7,75% = " + twoDecimalFormat.format(taxCalculatorService.getPreviousSocialHealthInsuranceFee()));

        System.out.println("Tax deductible expenses: "
				+ taxCalculatorService.getTaxDeductibleExpenses());

        System.out.println("Income: " + taxCalculatorService.getTaxedIncome()
				+ " rounded: " + noDecimalFormat.format(taxCalculatorService.getTaxedIncome()));

        System.out.println("Advance tax 18%: " + taxCalculatorService.getAdvanceTax());

        System.out.println("Tax free income: " + taxCalculatorService.getTaxFreeIncome());

        System.out.println("Reduced tax: " + twoDecimalFormat.format(taxCalculatorService.getTaxPaid()));

        System.out.println("Advance tax paid: " + twoDecimalFormat.format(taxCalculatorService.getAdvanceTaxPaid())
				+ " rounded: " + noDecimalFormat.format(taxCalculatorService.getAdvanceTaxPaid()));

        System.out.println("Net income: "+ taxCalculatorService.getNetIncome());
    }
}

