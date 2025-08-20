import java.util.Scanner;

class SquareSideCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get perimeter input from user
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Calculate side (Perimeter = 4 * side)
        double side = perimeter / 4;

        // Display result
        System.out.println("The length of the side is " + side + " for the perimeter " + perimeter);

        input.close();
    }
}
