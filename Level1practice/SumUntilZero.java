// Program Name: SumUntilZero
// Purpose: To calculate the sum of numbers entered by the user until 0 is entered

import java.util.Scanner;

class SumUntilZero {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        double number = 0.0;
        double totalSum = 0.0;

        // Prompt user for input and calculate sum until 0 is entered
        System.out.println("Enter numbers to sum (enter 0 to stop):");
        number = input.nextDouble();

        while (number != 0) {
            totalSum += number;
            number = input.nextDouble(); // Prompt again inside loop
        }

        // Display result
        System.out.println("The total sum of numbers entered = " + totalSum);

        // Close Scanner
        input.close();
    }
}
