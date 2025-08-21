// Program Name: SumUntilZeroOrNegative
// Purpose: To calculate sum using infinite loop and break when user enters 0 or negative number

import java.util.Scanner;

class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        double userInput = 0.0;
        double totalSum = 0.0;

        // Use infinite loop and break based on condition
        System.out.println("Enter numbers to sum (enter 0 or negative number to stop):");

        while (true) {
            userInput = input.nextDouble();

            // Break the loop if 0 or negative number is entered
            if (userInput <= 0) {
                break;
            }

            // Add input to totalSum
            totalSum += userInput;
        }

        // Display final sum
        System.out.println("The total sum of entered positive numbers = " + totalSum);

        // Close Scanner
        input.close();
    }
}
