// Program Name: OddEvenPrinter
// Purpose: To print odd and even numbers from 1 to a user-entered natural number

import java.util.Scanner;

class OddEvenPrinter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variable
        int number;

        // Prompt user to enter a number
        System.out.print("Enter a natural number: ");
        number = input.nextInt();

        // Validate if number is natural (positive)
        if (number >= 1) {
            // Loop from 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even");
                } else {
                    System.out.println(i + " is odd");
                }
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }

        // Close Scanner
        input.close();
    }
}
