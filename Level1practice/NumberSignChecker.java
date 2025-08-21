// Program Name: NumberSignChecker
// Purpose: To check if a number is positive, negative, or zero

import java.util.Scanner;

class NumberSignChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get input number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check and print sign
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        input.close();
    }
}
