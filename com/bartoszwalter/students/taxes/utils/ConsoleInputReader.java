package com.bartoszwalter.students.taxes.utils;

import com.bartoszwalter.students.taxes.enums.ContractType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleInputReader {

    private final BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public BigDecimal readIncome() throws IOException {
        BigDecimal income;
        while (true) {
            System.out.print("Enter income: ");
            try {
                income = new BigDecimal(reader.readLine().trim());
                if (income.compareTo(BigDecimal.ZERO) >= 0) {
                    break;
                } else {
                    System.out.println("Income cannot be negative. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }
        }
        return income;
    }

    public ContractType readContractType() throws IOException {
        ContractType contractType = null;
        while (contractType == null) {
            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            String input = reader.readLine().trim().toUpperCase();
            if (input.equals("E")) {
                contractType = ContractType.EMPLOYMENT;
            } else if (input.equals("C")) {
                contractType = ContractType.CIVIL;
            } else {
                System.out.println("Invalid contract type. Please enter 'E' for Employment or 'C' for Civil.");
            }
        }
        return contractType;
    }
}
