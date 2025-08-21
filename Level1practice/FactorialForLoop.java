

import java.util.Scanner;

class FactorialForLoop {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Declare variables
        int number;
        long factorial = 1;

        // Prompt user for input
        System.out.print("Enter a positive integer: ");
        number = input.nextInt();

        // Validate the number
        if (number >= 1) {
            // Calculate factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Display result
            System.out.println("Factorial of " + number + " using for loop is " + factorial);
        } else {
            System.out.println("Please enter a valid positive integer.");
        }

        // Close Scanner
        input.close();
    }
}
