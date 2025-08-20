import java.util.Scanner;

class BasicCalculator {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Take two floating-point inputs from user
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        // Display results
        System.out.println("The addition, subtraction, multiplication, and division of numbers " +
                           number1 + " and " + number2 + " is " +
                           addition + ", " + subtraction + ", " + multiplication + ", and " + division);

        input.close();
    }
}
