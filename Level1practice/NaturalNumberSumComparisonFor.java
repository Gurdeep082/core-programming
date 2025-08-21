// Program Name: NaturalNumberSumComparisonFor
// Purpose: To find the sum of n natural numbers using for loop and compare with formula

import java.util.Scanner;

class NaturalNumberSumComparisonFor {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variable
        int number;

        // Prompt user for input
        System.out.print("Enter a natural number: ");
        number = input.nextInt();

        // Validate input
        if (number >= 1) {
            int loopSum = 0;

            // Sum using for loop
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }

            // Sum using formula
            int formulaSum = number * (number + 1) / 2;

            // Display both results
            System.out.println("Sum using for loop = " + loopSum);
            System.out.println("Sum using formula  = " + formulaSum);

            // Verify match
            if (loopSum == formulaSum) {
                System.out.println("Both computations are correct and match.");
            } else {
                System.out.println("Mismatch in calculations.");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }

        // Close Scanner
        input.close();
    }
}
