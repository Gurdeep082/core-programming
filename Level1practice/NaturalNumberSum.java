// Program Name: NaturalNumberSum
// Purpose: To check if a number is a natural number and compute sum of n natural numbers

import java.util.Scanner;

class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number from user
        System.out.print("Enter a number to check and find sum of n natural numbers: ");
        int number = input.nextInt();

        // Check for natural number (positive integer)
        if (number >= 1) {
            // Compute sum using formula
            int sum = number * (number + 1) / 2;

            // Print the result
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }

        input.close();
    }
}
