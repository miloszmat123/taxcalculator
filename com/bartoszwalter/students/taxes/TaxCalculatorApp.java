package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.enums.ContractType;
import com.bartoszwalter.students.taxes.services.CivilTaxCalculator;
import com.bartoszwalter.students.taxes.services.EmploymentTaxCalculator;
import com.bartoszwalter.students.taxes.services.TaxReportGenerator;
import com.bartoszwalter.students.taxes.utils.ConsoleInputReader;

import java.io.IOException;
import java.math.BigDecimal;

class TaxCalculatorApp {

    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();

        try {
            BigDecimal income = inputReader.readIncome();
            ContractType contractType = inputReader.readContractType();

            // Can be replaced with Strategy pattern
            switch (contractType) {
                case EMPLOYMENT:
                    EmploymentTaxCalculator employmentTaxCalculator = new EmploymentTaxCalculator(income);
                    TaxReportGenerator.generateTaxReport(employmentTaxCalculator);
                    break;
                case CIVIL:
                    CivilTaxCalculator civilTaxCalculator = new CivilTaxCalculator(income);
                    TaxReportGenerator.generateTaxReport(civilTaxCalculator);
                    break;
                default:
                    System.out.println("Unknown type of contract!");
            }

        } catch (IOException ex) {
            System.out.println("An error occurred during input.");
            ex.printStackTrace();
        }
    }
}
