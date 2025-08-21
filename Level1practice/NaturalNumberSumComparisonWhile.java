// Program Name: NaturalNumberSumComparisonWhile
// Purpose: To find the sum of n natural numbers using while loop and compare with formula

import java.util.Scanner;

class NaturalNumberSumComparisonWhile {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        int number;
        int counter = 1;
        int loopSum = 0;

        // Prompt user for a natural number
        System.out.print("Enter a natural number: ");
        number = input.nextInt();

        // Validate for natural number
        if (number >= 1) {
            // Sum using while loop
            while (counter <= number) {
                loopSum += counter;
                counter++;
            }

            // Sum using formula
            int formulaSum = number * (number + 1) / 2;

            // Display both results
            System.out.println("Sum using while loop = " + loopSum);
            System.out.println("Sum using formula     = " + formulaSum);

            // Verify if both sums match
            if (loopSum == formulaSum) {
                System.out.println("Both computations are correct and match.");
            } else {
                System.out.println("There is a mismatch in computations.");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }

        // Close Scanner
        input.close();
    }
}
