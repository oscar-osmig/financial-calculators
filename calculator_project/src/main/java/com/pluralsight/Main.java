package com.pluralsight;

import java.util.Scanner;

public class Main {
    static boolean wrong = true;
    // verifying user input is an integer
    public static boolean validate_choice(String choice){
        try
        {   // convertin input to integer
            Integer.parseInt(choice); // "123" -> 123
            return true;
        }
        catch (Exception E)
        {
            return false;
        }
    }

    public static void choice(String choice){

        if(validate_choice(choice))
        {
            // JOptionPane.showMessageDialog(null, "Valid Choice");
            // System.out.println("Valid Choice!");
            switch (choice){
                case "1": //
                    System.out.println("Running MorgageCalculator.java shortly");
                    MortgageCalculator.main();
                    wrong = false;
                    break;
                case "2":
                    System.out.println("Running FutureValueCalculator.java shortly");
                    wrong = false;
                    break;
                case "3":
                    System.out.println("Running PresentValueCalculator.java shortly");
                    wrong = false;
                    break;
                default:
                    System.out.println("Invalid Choice, please choose again...");

            }
        }else
        { // JOptionPane.showMessageDialog(null, "Invalid Choice");
            System.out.println("Invalid Choice!");


        }

    }



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n        ** Welcome to Calc Enterpice ** \n" +
                    "\n      Please choose one of our available tools\n" +
                    "\n        1. Morgage Calculator" +
                    "\n        2. Future Value Calculation" +
                    "\n        3. Present Value Calculator " +
                    "\n\n        Your choice: ");

            String choice = scanner.nextLine();
            validate_choice(choice);

            choice(choice);
        } while (wrong);
    }
}