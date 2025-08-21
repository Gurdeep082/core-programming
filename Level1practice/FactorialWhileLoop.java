import java.util.Scanner;

class FactorialWhileLoop {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Declare variables
        int number;
        long factorial = 1;

        // Get user input
        System.out.print("Enter a positive integer: ");
        number = input.nextInt();

        // Validate input for positive integer
        if (number >= 1) {
            int counter = 1;

            // Calculate factorial using while loop
            while (counter <= number) {
                factorial *= counter;
                counter++;
            }

            // Display result
            System.out.println("Factorial of " + number + " using while loop is " + factorial);
        } else {
            System.out.println("Please enter a valid positive integer.");
        }

        // Close Scanner
        input.close();
    }
}
