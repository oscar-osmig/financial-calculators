package com.pluralsight;
import java.text.NumberFormat;
import java.util.Scanner;

public class PresentValueCalculator {
    public static boolean again = true;
    public static void calculate(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n                ** Present Value Caculator **\n");
        System.out.println("What's the payment per period?");
        float payment = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("What's the interest rate?");
        float interest = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("What's the total years?");
        int years = scanner.nextInt();
        scanner.nextLine();

        interest /= 100;
        double present_value = payment * (1 - Math.pow(1 + interest, -years)) / interest;

        System.out.println("\n\nYour payment: " + NumberFormat.getCurrencyInstance().format(payment) +
                           "\nInterest rate: " + NumberFormat.getPercentInstance().format(interest) +
                           "\nTerm: " + years + " years" +
                           "\nPresent Value: " + NumberFormat.getCurrencyInstance().format(present_value)
                );

        System.out.println("\n                  Quit and go to main page: (y/n)");
        String calculate = scanner.nextLine();
        if (calculate.equals("y")){
            Main.board(scanner);
            again = false;
        }
    }

    public static void main()
    {
        do {
            calculate();
        }while (again);
    }
}
