import java.util.Scanner;

class DivisibleByFiveChecker {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Take input number from user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if number is divisible by 5
        boolean isDivisible = (number % 5 == 0);

        // Display result
        System.out.println("Is the number " + number + " divisible by 5 :-> " + isDivisible);

        // Close Scanner
        input.close();
    }
}
