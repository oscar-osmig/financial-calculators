package com.pluralsight;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator
{
    public static boolean again = true;
    private static final int MONTHS_IN_YEARS = 12;

    public static void calculate(){
        System.out.println("\n                ** Morgage  Calculator **\n");

        final int MONTHS_IN_A_YEAR = 12;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter the annual interest rate:");
        double annualInterestRate = scanner.nextFloat();

        System.out.println("Enter the term in years:");
        int termInYears = scanner.nextInt();
        scanner.nextLine();


        // annual percentage
        annualInterestRate /= 100;
        // calculating monthly rate
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
        // how to calculate amount of payments
        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;
        // formula for monthly payment [  M = P [ (r(1+r)^n) / ((1+r)^n - 1) ]  ]
        double monthlyPayment = principal * (
                (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
        );

        double totalPayment = monthlyPayment * numberOfPayments;
        System.out.println("\nPrincipal amount: " + NumberFormat.getCurrencyInstance().format(principal) +
                "\nAnnual interes rate: " + NumberFormat.getInstance().format(annualInterestRate*100) +
                "\nAmount of years: " + NumberFormat.getIntegerInstance().format(termInYears) +
                "\nMonthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment) +
                "\nTotal interest: " + NumberFormat.getCurrencyInstance().format(totalPayment - principal));

        System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));

        System.out.println("\n                  Quit and go to main page: (y/n)");
        String calculate = scanner.nextLine();
        if (calculate.equals("y")){
            Main.board(scanner);
            again = false;
        }
    }


    public static void main() {
        // need input of:
        // 1. Principal and interest: The amount paid towards the loan's principles balance and interest.
        // 2. Property Taxes: Annual taxes divided by 12 for monthly payments.
        // 3. Homeowner’s Insurance: Annual insurance premium divided by 12 for monthly payments.
        // 4. Private Mortgage Insurance (PMI): Required when the down payment is less than 20% of the home’s price.

        do {
            calculate();

        } while (again);

    }
}
