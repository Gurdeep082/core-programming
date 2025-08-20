import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input base and height in centimeters
        System.out.print("Enter base in cm: ");
        double baseInCm = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightInCm = input.nextDouble();

        // Area in square centimeters
        double areaInSqCm = 0.5 * baseInCm * heightInCm;

        // Convert area to square inches (1 inch = 2.54 cm)
        double areaInSqIn = areaInSqCm / (2.54 * 2.54);

        // Display the result
        System.out.println("The Area of the triangle is " + areaInSqIn + " sq in and " + areaInSqCm + " sq cm");

        input.close();
    }
}
