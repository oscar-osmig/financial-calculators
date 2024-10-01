package com.pluralsight;

import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueCalculator
{
    public static boolean again = true;
    static final double COMPOUNDED_DAILY = 365;

    public static void calculate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n        ** Future Value Calculator ** \n" );

        System.out.println("\nHow much do you want to invest?");
        double investment = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nHow many years?");
        int years = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What's the interest rate?");
        double interest_rate = scanner.nextFloat();
        scanner.nextLine();

        interest_rate /= 100.0f;
        // A = 10,000 (1+0.025 / 365) ^ (365*5) | A = P(1+r/n)^(nt) n = 365
        double tn = COMPOUNDED_DAILY * years;
        double future_value = investment * Math.pow(1 + (interest_rate / COMPOUNDED_DAILY), tn);
        System.out.println("Earnings: " + NumberFormat.getCurrencyInstance().format(future_value));
        //System.out.println(0.1 + 0.2);

        System.out.println("\nQuit and go to main page: (y/n)");
        String calculate = scanner.nextLine();
        if (calculate.equals("y")){
            Main.board(scanner);
            again = false;
        }
    }


    public static void main(String[] args) {

        do {
            calculate();

        } while (again);

    }
}
