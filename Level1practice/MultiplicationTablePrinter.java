// Program Name: MultiplicationTablePrinter
// Purpose: To print multiplication table of a number from 6 to 9

import java.util.Scanner;

class MultiplicationTablePrinter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variable
        int number;

        // Get user input
        System.out.print("Enter a number for multiplication table: ");
        number = input.nextInt();

        // Display multiplication table from 6 to 9
        System.out.println("Multiplication table for " + number + " from 6 to 9:");
        for (int i = 6; i <= 9; i++) {
            int product = number * i;
            System.out.println(number + " * " + i + " = " + product);
        }

        // Close Scanner
        input.close();
    }
}
