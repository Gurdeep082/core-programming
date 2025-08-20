import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking input for perimeter
        System.out.print("Enter the perimeter of the square: ");
        float perimeter = input.nextFloat();

        // Calculating side length
        float side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
